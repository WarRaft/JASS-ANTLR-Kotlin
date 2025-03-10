grammar As;

// https://www.angelcode.com/angelscript/sdk/docs/manual/doc_script_bnf.html

root : rootItem* EOF ;
rootItem : include|namespace|stmt|funcdef|func;

include : INCLUDE STRING;

namespace : NAMESPACE ID (COL_COL ID)* LBRACE rootItem* RBRACE;

typename : ID;
varname : ID;

param : typename varname ;

funcdef : FUNCDEF ID varname LPAREN ID? (COMMA ID)* RPAREN SEMI;

/*
PARAMLIST     ::= '(' ['void' | (TYPE TYPEMOD [IDENTIFIER] ['=' EXPR] {',' TYPE TYPEMOD [IDENTIFIER] ['=' EXPR]})] ')'
TYPEMOD       ::= ['&' ['in' | 'out' | 'inout']]
TYPE          ::= ['const'] SCOPE DATATYPE ['<' TYPE {',' TYPE} '>'] { ('[' ']') | ('@' ['const']) }

SCOPE         ::= ['::'] {IDENTIFIER '::'} [IDENTIFIER ['<' TYPE {',' TYPE} '>'] '::']
*/

func :
    typename varname
    LPAREN (param (COMMA param)*)? RPAREN
    (stmt | LBRACE stmt* RBRACE)
    ;

// === STATEMENT

left
    : AT? ID #leftId
    | ID left #leftType
    | left COMMA left #leftComma
    | left LPAREN (expr (COMMA expr)*)? RPAREN #leftCall
    | left LBRACK expr? RBRACK #leftArr
    | left DOT left #leftDot
    | COL_COL left #leftCol
    ;


stmt
    : left ((EQ|ADD_EQ|SUB_EQ|MUL_EQ|DIV_EQ) expr)? SEMI #stmtLeft
    | RETURN expr? SEMI #stmtReturn
    | FOR LPAREN (stmt|expr|SEMI) expr? SEMI expr? RPAREN (stmt | (LBRACE stmt* RBRACE)) #stmtFor
    | (IF|WHILE) LPAREN expr RPAREN (stmt | (LBRACE stmt* RBRACE)) elseRule? #stmtIf
    ;

elseRule : ELSE (stmt | (LBRACE stmt* RBRACE));

// === EXPRESSION
expr
    : expr DOT expr #exprDot
    | LPAREN expr RPAREN # exprParen // 1
    | (SUB|NOT) expr # exprPre // 2
    | expr (ADD_ADD) # exprPost
    | expr (MUL|DIV) expr # exprMul  // 3
    | expr (SUB|ADD) expr # exprAdd // 4
    | expr (LT|LT_EQ|GT|GT_EQ) expr # exprLt
    | expr (EQ_EQ|NEQ) expr # exprEq
    | expr (AND_AND|OR_OR) expr # exprAnd
    | expr COL_COL expr # exprCol
    | (INTVAL|HEXVAL|RAWVAL) # exprInt
    | REALVAL # exprReal
    | STRING # exprStr
    | expr LBRACK expr? RBRACK # exprArr
    | expr LPAREN (expr (COMMA expr)*)? RPAREN # exprCall
    | LPAREN RPAREN LBRACE stmt* RBRACE # exprLambda
    | AT? ID # exprVar
    ;

RAWVAL: '\'' (~['])* '\'';

STRING : '"' (STRING_ESC | STRING_CLOSE)* '"' ;
fragment STRING_ESC : '\\' . ;
fragment STRING_CLOSE : ~["\\] ;

INCLUDE : '#include';
NAMESPACE : 'namespace';
COL_COL : '::';
AT : '@';
CONST : 'const';
ELSE : 'else';
FOR : 'for';
FUNCDEF : 'funcdef';
IF : 'if';
PUBLIC : 'public';
PRIVATE : 'private';
RETURN : 'return';

WHILE : 'while';

NOT : '!';

DOT : '.';
COMMA : ',';

EQ_EQ: '==';
NEQ : '!=';
EQ : '=';
ADD_EQ : '+=';
SUB_EQ : '-=';
MUL_EQ : '*=';
DIV_EQ : '/=';

LT_EQ : '<=';
LT : '<';
GT_EQ: '>=';
GT : '>';

ADD_ADD: '++';
ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
AND_AND : '&&';
OR_OR : '||';

LPAREN : '(';
RPAREN : ')';
LBRACK : '[';
RBRACK : ']';
LBRACE : '{';
RBRACE : '}';
SEMI : ';';

ID : [A-Za-z_][_0-9A-Za-z]*;

fragment HexDigit: [0-9a-fA-F];

INTVAL: ('0' .. '9')+;
HEXVAL: (('0' [xX])| '$' )  HexDigit+;

REALVAL : (('0' .. '9')* '.' ('0' .. '9')+)|(('0' .. '9')+ '.' ('0' .. '9')*)'f'?;

WS: [ \t]+ -> skip;
NL: [\r\n] -> skip;

COMMENT : '/*' (COMMENT|.)*? '*/' -> channel(2) ;
LINE_COMMENT: '//' ~[\r\n]* -> channel(2);
