grammar Bni;

root        : (section | entry | NEWLINE)* EOF;

section     : '[' ID ']' NEWLINE;
entry       : (ID WS*)? VALUE NEWLINE?;

ID  : [a-zA-Z0-9_ ]+;
VALUE: '=' ~[\r\n]*;
WS          : [ \t]+ -> skip;
NEWLINE     : '\r'? '\n';
LINE_COMMENT     : '//' ~[\r\n]* -> channel(2);
