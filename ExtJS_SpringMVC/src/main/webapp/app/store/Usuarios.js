Ext.define('Teste.store.Usuarios', {
	extend : 'Ext.data.Store',
	storeId : 'usuarioStore',
	id: 'usuarioStore',
	alias: 'store.usuarioStore',
	model : 'Teste.model.Usuario',
	fields : [ 'id', 'nome', 'email' ],
	proxy : {
		type : 'ajax',
		url : 'modules/usuario/listar',
		reader : {
			type : 'json',
			rootProperty : 'usuarios'
		}
	},
	autoLoad: true
});

