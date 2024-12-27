// $antlr-format alignTrailingComments true, columnLimit 150, minEmptyLines 1, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine false, allowShortBlocksOnASingleLine true, alignSemicolons hanging, alignColons hanging

grammar  Jass ;

// https://github.com/antlr/grammars-v4
// https://github.com/antlr/antlr4/blob/master/doc/options.md

root : (type | native | globals | function)* EOF ;

typename : ID;
varname : ID;
funname : ID;

// === type
type : TYPE typename extends;
extends : EXTENDS typename;

// === globals
globals : GLOBALS variable* ENDGLOBALS;

// === var
variable : CONSTANT? LOCAL? typename ARRAY? varname (EQ expr)?;

// === function
param : typename varname;
params : param (COMMA param)*  ;

takes : TAKES (NOTHING|params);
returns_ : RETURNS (NOTHING|typename);

native : CONSTANT? NATIVE funname takes returns_;
function : CONSTANT? FUNCTION funname takes returns_ stmt* ENDFUNCTION ;

// === STATEMENT
stmt
    : variable
    | set
    | call
    | return
    | if
    | loop
    | exitwhen
    ;

set : SET (primarr|varname) EQ expr;

call : DEBUG? CALL primcall;

return : RETURN expr?;

if : IF expr THEN? (stmt|elseif|else)* ENDIF;
elseif : ELSEIF expr THEN? stmt*;
else : ELSE stmt*;

loop : LOOP stmt* ENDLOOP ;
exitwhen : EXITWHEN expr ;

// === EXPRESSION
expr
    : expr PLUS expr
    | expr MINUS expr
    | expr MUL expr
    | expr DIV expr
    | MUL expr
    | DIV expr
    | PLUS expr
    | MINUS expr
    | NOT expr
    | expr EQ_EQ expr
    | expr NEQ expr
    | expr LT expr
    | expr LT_EQ expr
    | expr GT expr
    | expr GT_EQ expr
    | expr OR expr
    | expr AND expr
    | LPAREN expr RPAREN
    | prim
    ;

prim
    : primarr
    | primcall
    | primfun
    | FALSE
    | NULL
    | TRUE
    | INTVAL
    | HEXVAL
    | REALVAL
    | RAWVAL
    | STRING
    | ID
    ;

primcall : funname LPAREN (expr (COMMA expr)*)? RPAREN;
primarr : varname LBRACK expr? RBRACK;
primfun : FUNCTION ID;


RAWVAL: '\'' (~['])* '\'';

STRING : '"' (STRING_ESC | STRING_CLOSE)* '"' ;
fragment STRING_ESC : '\\' . ;
fragment STRING_CLOSE : ~["\\] ;

AND : 'and';
ARRAY : 'array';
CALL : 'call';
CONSTANT : 'constant';
DEBUG : 'debug';
ELSE : 'else';
ELSEIF : 'elseif';
ENDFUNCTION : 'endfunction';
ENDIF : 'endif';
ENDLOOP : 'endloop';
ENDGLOBALS : 'endglobals';
EXTENDS : 'extends';
EXITWHEN : 'exitwhen';
FALSE : 'false';
FUNCTION : 'function';
GLOBALS : 'globals';
IF : 'if';
LOCAL : 'local';
LOOP : 'loop';
NATIVE : 'native';
NOT : 'not';
NOTHING : 'nothing';
NULL : 'null';
OR : 'or';
RETURNS : 'returns';
RETURN : 'return';
SET : 'set';
TAKES : 'takes';
THEN : 'then';
TRUE : 'true';
TYPE : 'type';
COMMA : ',';
EQ_EQ: '==';
EQ : '=';
NEQ : '!=';
LT_EQ : '<=';

LT : '<';
GT_EQ: '>=';
GT : '>';
PLUS : '+';
MINUS : '-';
MUL : '*';
DIV : '/';
LPAREN : '(';
RPAREN : ')';
LBRACK : '[';
RBRACK : ']';

ID : [A-Za-z_][_0-9A-Za-z]*;

fragment HexDigit: [0-9a-fA-F];

INTVAL: ('0' .. '9')+;
HEXVAL: (('0' [xX])| '$' )  HexDigit+;

REALVAL : (('0' .. '9')* '.' ('0' .. '9')+)|(('0' .. '9')+ '.' ('0' .. '9')*);


WS: [ \t]+ -> channel(HIDDEN);
NL: [\r\n] -> channel(2);

LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
