grammar ourC;

/* SKIP COMMENTS AND WHITESPACES - START */
COMMENT_START: '//' ~[\r\n]* -> skip;
BLANK_SPACE: [ \r\t\n]+ -> skip ;
/* SKIP COMMENTS AND WHITESPACES - END */


/* --- LEXICAL RULES - START --- */
/* OPERATORS - START */
OP_MULTIPLICATION : '*';
OP_MINUS : '-';
OP_PLUS : '+';
OP_DIVISION: '/';

COMP_IDENT : '==';
COMP_NOT_IDENT: '!=';
COMP_GRTH: '>';
COMP_GRTH_EQ: '>=';
COMP_LW: '<';
COMP_LW_EQ: '<=';
ASSIGN: '=';

NEGATION: '!';
QUES_MARK: '?';
OPER_AND: '&';
OPER_OR: '|';
COLON: ':' ;
SEMI_COLON: ';' ;

BOOL_TRUE: 'true';
BOOL_FALSE: 'false';
/* OPERATORS - END */

/* BRACKETS - START */
LEFT_BASIC_BRACK: '(';
RIGHT_BASIC_BRACK: ')';
LEFT_CURLY_BRACK: '{';
RIGHT_CURLY_BRACK: '}';
LEFT_NARROW_BRACK: '[';
RIGHT_NARROW_BRACK: ']';
COMMA: ',';
END_OF_COM: '\n';
/* BRACKETS - END */

/* CONDITIONS - START */
CON_IF: 'if';
CON_ELSE: 'else';
/* CONDITIONS - END */

/* LOOPS - START */
CYC_WHILE: 'while';
CYC_FOR: 'for';
CYC_FOREACH: 'foreach';
CYC_REPEAT: 'repeat';
CYC_UNTIL: 'until';
CYC_DO: 'do';
TO: 'to';
/* LOOPS - END */

/* DATA TYPES - START */
BOOL: 'bool';
INT: 'int';
STRING: 'string';
CONST: 'const';

PROC_DEF: 'procedure';

DEC_NUM: [0-9]+;
IDENT: [a-zA-Z_][0-9a-zA-Z_]*;
STRING_DEC: '"'('\\'[btnfr"'\\] | ~[\r\n\\"] )*'"';
/* DATA TYPES - END */



/* --- LEXICAL RULES - END --- */

/* --- PARSER RULES - START --- */
identifier_var
    : IDENT;

bool_val
    : BOOL_TRUE
    | BOOL_FALSE;

dec_val
    : /*sign_whole_num?*/ DEC_NUM;

string_val
    : STRING_DEC;
//sign_whole_num
//    : OP_PLUS
//    | OP_MINUS;
multi_assign
    : ASSIGN identifier_var;

expr_dec_bool
    : dec_val
    | bool_val
    | identifier_var
    | identifier_var LEFT_NARROW_BRACK DEC_NUM RIGHT_NARROW_BRACK
    | expr_dec_bool op=(OP_MULTIPLICATION | OP_DIVISION) expr_dec_bool
    | expr_dec_bool op=(OP_PLUS | OP_MINUS) expr_dec_bool
    | expr_dec_bool op=(COMP_LW | COMP_LW_EQ | COMP_GRTH | COMP_GRTH_EQ | COMP_IDENT | COMP_NOT_IDENT) expr_dec_bool
    | expr_dec_bool op=(OPER_AND | OPER_OR) expr_dec_bool
    | expr_string (COMP_IDENT | COMP_NOT_IDENT) expr_string ((OPER_AND | OPER_OR) expr_dec_bool)?
    | LEFT_BASIC_BRACK expr_dec_bool RIGHT_BASIC_BRACK
    | NEGATION expr_dec_bool;
//    | OP_PLUS expr_dec_bool
//    | OP_MINUS expr_dec_bool;

expr_string
    : string_val
    | identifier_var
    | expr_string OP_PLUS expr_string
    | LEFT_BASIC_BRACK expr_string RIGHT_BASIC_BRACK
    ;

bool_var_dec
    : BOOL identifier_var (multi_assign)* ASSIGN expr_dec_bool;

decimal_var_dec
    : INT identifier_var (multi_assign)* ASSIGN /*sign_whole_num?*/ expr_dec_bool;

string_var_dec
    : STRING identifier_var (multi_assign)* ASSIGN expr_string;

array_var_dec
    : (INT | BOOL) identifier_var LEFT_NARROW_BRACK DEC_NUM RIGHT_NARROW_BRACK;

var_non_const_dec_command
    : (bool_var_dec | decimal_var_dec | string_var_dec | array_var_dec) SEMI_COLON;

var_const_dec_command
    : CONST (bool_var_dec | decimal_var_dec | string_var_dec | array_var_dec) SEMI_COLON;

var_declaration
    : (var_non_const_dec_command | var_const_dec_command);

var_assignment
    : identifier_var ASSIGN (expr_dec_bool | expr_string) SEMI_COLON;

arr_assignment
    : identifier_var LEFT_NARROW_BRACK DEC_NUM RIGHT_NARROW_BRACK ASSIGN (expr_dec_bool) SEMI_COLON;

ternar_assignment
    : identifier_var ASSIGN LEFT_BASIC_BRACK expr_dec_bool RIGHT_BASIC_BRACK QUES_MARK (expr_dec_bool | expr_string) COLON (expr_dec_bool | expr_string) SEMI_COLON;

ternar_declaration
    : (BOOL | INT | STRING) ternar_assignment;

call_proc
    : identifier_var LEFT_BASIC_BRACK ((expr_dec_bool | expr_string) (COMMA (expr_dec_bool | expr_string))*)? RIGHT_BASIC_BRACK;

code_block
    : var_declaration
    | var_assignment
    | arr_assignment
    | ternar_assignment
    | ternar_declaration
    | call_proc SEMI_COLON
    | CON_IF LEFT_BASIC_BRACK expr_dec_bool RIGHT_BASIC_BRACK block_body (CON_ELSE block_body)?
    | CYC_WHILE LEFT_BASIC_BRACK expr_dec_bool RIGHT_BASIC_BRACK block_body
    | CYC_FOR LEFT_BASIC_BRACK identifier_var ASSIGN dec_val? expr_dec_bool TO dec_val? expr_dec_bool RIGHT_BASIC_BRACK block_body
    | CYC_FOREACH LEFT_BASIC_BRACK identifier_var COLON identifier_var RIGHT_BASIC_BRACK block_body
    | CYC_REPEAT block_body CYC_UNTIL LEFT_BASIC_BRACK expr_dec_bool RIGHT_BASIC_BRACK SEMI_COLON
    | CYC_DO block_body CYC_WHILE LEFT_BASIC_BRACK expr_dec_bool RIGHT_BASIC_BRACK SEMI_COLON;

block_body
    : LEFT_CURLY_BRACK ((code_block)+)? RIGHT_CURLY_BRACK;

def_proc
    : PROC_DEF identifier_var LEFT_BASIC_BRACK (((BOOL | INT) expr_dec_bool | (STRING) expr_string) (COMMA ((BOOL | INT) expr_dec_bool | (STRING) expr_string))*)? RIGHT_BASIC_BRACK block_body;

start
    : ((code_block | def_proc)+)?;
/* --- PARSER RULES - END --- */