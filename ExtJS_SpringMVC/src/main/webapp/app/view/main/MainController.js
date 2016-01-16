Ext
		.define(
				'Teste.view.main.MainController',
				{
					extend : 'Ext.app.ViewController',

					alias : 'controller.main',

					onClickButton : function() {
						var form = Ext.getCmp('form')
						var values = form.getForm().getValues();
						if (!form.isValid()) {
							Ext.Msg.alert("Erro", "Informe todos os dados.");
							return false;
						}
						console.log(values);
						Ext.Ajax
								.request({
									url : 'modules/usuario/adicionar',
									method : 'POST',
									jsonData : values,
									success : function(response) {
										Ext.Msg
												.alert("Sucesso",
														"O usu&aacuterio foi cadastrado com sucesso.");
										console.log('sucesso: '
												+ response.responseText);
										Ext.getCmp('grid').getStore().load();
									}
								});
					},
					removerUsuario : function(button) {
						var grid = button.up('grid');
					},
					teste : function(grid, record, index, eOpts) {
						Ext.Msg
								.confirm(
										"Remover Usu&aacuterio",
										"Deseja remover o usu&aacuterio selecionado?",
										function(buttonId) {
											console.log(buttonId);
											if (buttonId == 'yes') {
												console.log(record.getData());
												Ext.Ajax
														.request({
															url : 'modules/usuario/remover',
															method : 'POST',
															jsonData : record
																	.getData(),
															success : function(
																	response) {
																Ext.Msg
																		.alert(
																				"Sucesso",
																				"O usu&aacuterio foi removido com sucesso.");
																console
																		.log('sucesso: '
																				+ response.responseText);
																Ext
																		.getCmp(
																				'grid')
																		.getStore()
																		.load();

															}
														});
											}
										});
					}

				});