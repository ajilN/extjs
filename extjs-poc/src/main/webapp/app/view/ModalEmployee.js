Ext.define("extjspoc.view.ModalEmployee", {
	extend: 'Ext.window.Window',
	alias: ['widget.modalemployee'],
	id:'modalemployee-window',
	title: 'Employee Info',
    height: 300,
    width: 400,
    layout: 'fit',
    modal :true,
    items: [{
        xtype: 'modalForm',
        id:'emp-modal-form'
    }],
    buttons: [{
    	 text: 'Update',
    	 handler: function() {
    		 debugger;
    		 Ext.getCmp('emp-modal-form').updateRecord();
    		 var record = Ext.getCmp('emp-modal-form').getRecord();
    		 Ext.getCmp('modalemployee-window').close();
    		 Ext.getCmp('employee-grid').getView().refresh();
    		 Ext.getStore('Employee').sync();
    		 //Ext.Msg.alert('Success --- ');
    		 
    	 }
    }]
});