// $antlr-format alignTrailingComments true, columnLimit 150, minEmptyLines 1, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine false, allowShortBlocksOnASingleLine true, alignSemicolons hanging, alignColons hanging

grammar  Jass ;

// https://github.com/antlr/grammars-v4
// https://github.com/antlr/antlr4/blob/master/doc/options.md

root : (typeDef | nativ | glob | fun)* EOF ;

typeName : ID;
varName : ID;

// === type
typeDef : TYPE typeName typeExt;
typeExt : EXTENDS typeName;

// === globals
var : typeName ARRAY? varName (EQ expr)?;

glob : GLOBALS varDefGlob* ENDGLOBALS;
varDefGlob : CONSTANT? var;

// === function
argList : expr (COMMA expr)*;
funCall : ID LPAREN argList? RPAREN;

param : typeName ID ;
paramList : param (COMMA param)*  ;

funTake : TAKES (NOTHING|paramList);
funRet : RETURNS (NOTHING|typeName);
fun : CONSTANT? FUNCTION funHead stmt* ENDFUNCTION ;
funHead : ID funTake funRet;

nativ : CONSTANT? NATIVE funHead;

// === STATEMENT
stmt
    : setStmt
    | callStmt
    | varDefLoc
    | returnStmt
    | ifStmt
    | loopStmt
    | exitWhenStmt
    ;

varDefLoc : LOCAL? var;

setStmt : SET (arrayAccess|ID) EQ expr;

callStmt : DEBUG? CALL funCall;

returnStmt : RETURN expr?;

ifStmt : IF expr THEN? (stmt|elseIfStmt|elseStmt)* ENDIF;
elseIfStmt : ELSEIF expr THEN? stmt*;
elseStmt : ELSE stmt*;

loopStmt : LOOP stmt* ENDLOOP  ;
exitWhenStmt :EXITWHEN expr  ;

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
    : arrayAccess
    | funCall
    | funRef
    | FALSE
    | NULL
    | TRUE
    | HEXVAL
    | REALVAL
    | INTVAL
    | RAWVAL
    | STRVAL
    | ID
    ;

arrayAccess : ID LBRACK expr? RBRACK;
funRef : FUNCTION ID;

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
STRING : 'string';
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
INTVAL: Digit+;
fragment Digit: [0-9];

STRVAL: '"'  ~('\\' | '"')* '"';

RAWVAL: '\''  ~('\'' | '\\')* '\'';

fragment HexDigit: [0-9a-fA-F];

HEXVAL: '0' [xX] HexDigit+;

REALVAL : [0-9]+.[0-9]*|.[0-9]+;

WS: [ \t]+ -> channel(HIDDEN);
NL: [\n\r] -> channel(2);

LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
