Ext.define('Teste.Application', {
	extend: 'Ext.app.Application',

	name: 'Teste',

	models: ['Usuario'],
	
	stores: ['Usuarios'],

	views: ['main.Main'],
	        
	//requires: ['Teste.store.Usuarios'],
	           
	launch: function() {
		
		Ext.create('Teste.view.main.Main');
	}
});
