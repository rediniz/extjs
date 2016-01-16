Ext.define('Teste.model.Usuario', {
	alternateClassName: 'Usuario',
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'nome', type: 'string'},
        {name: 'email', type: 'string'}
    ],


});