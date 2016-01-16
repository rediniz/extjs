//Ext.require('Teste.store.Usuarios');
//s = Ext.create("Teste.store.Usuarios");
//s.load();
Ext.define('Teste.view.main.Main', {
	extend : 'Ext.form.Panel',
	requires : [ 'Teste.view.main.MainController' ],
	controller : 'main',
	renderTo : document.body,
	title : 'Cadastro de Usu&aacuterios',
	autoHeight : true,
	width : 500,
	bodyPadding : 10,
	id : 'panel',
	iconCls : 'icon-user',
	items : [ {
		xtype : 'form',
		layout : 'anchor',
		alias : 'form',
		id : 'form',
		bodyStyle : {
			background : 'none',
			padding : '10px',
			border : '0'
		},
		defaults : {
			xtype : 'textfield'
		},
		items : [ {
			fieldLabel : 'Nome',
			name : 'nome',
			allowBlank : false,
			blankText : "Este campo precisa ser preechido.",
			emptyText : "Informe seu nome"
		}, {
			fieldLabel : 'Email',
			name : 'email',
			allowBlank : false,
			blankText : "Este campo precisa ser preechido.",
			emptyText : "Informe seu email",
			vtype : 'email'
		}, {
			xtype : 'button',
			text : 'Cadastrar',
			margin : '10 0',
			handler : 'onClickButton',
			itemId : 'cadastrarButton',
			formBind : true
		}, {
			xtype : 'grid',
			title : 'Usu&aacuterios Cadastrados',
			id : 'grid',
			listeners : {
				select : 'teste'
			},
			store : {
				type : 'usuarioStore'
			},
			columns : [ {
				text : 'Id',
				dataIndex : 'id',
				id : 'id'

			}, {
				text : 'Nome',
				dataIndex : 'nome'
			}, {
				text : 'Email',
				dataIndex : 'email',
				flex : 1
			}, {
				xtype : 'actioncolumn',
				text : 'Remover',
				align : 'center',
				items : [ {
					icon : 'resources/images/delete.png',
					align : 'center'
				} ],
				listeners : {
					click : 'removerUsuario'
				}
			}

			],
		} ]
	} ]
});
