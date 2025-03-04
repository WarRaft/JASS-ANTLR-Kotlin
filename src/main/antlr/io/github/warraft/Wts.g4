grammar Wts;

root : item* EOF ;

item : STRING NUMBER BLOCK;

STRING : 'STRING';
NUMBER: ('0' .. '9')+;

BLOCK: '{' (~'}')* '}' ;

LINE_COMMENT: '//' ~[\r\n]* -> channel(2);

WS: [ \t]+ -> skip;
NL: [\r\n] -> skip;
