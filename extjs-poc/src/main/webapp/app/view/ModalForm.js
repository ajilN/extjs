Ext.define('extjspoc.view.ModalForm' ,{
    extend: 'Ext.form.Panel',
    id:'modalForm-emp',
    alias : 'widget.modalForm',
    header :false,
    margin: '0 0 0 10',
    defaults: {
        width: 240,
        labelWidth: 90
    },
    defaultType: 'textfield',
    items: [{
        fieldLabel: 'Name',
        name: 'name'
    },{
        fieldLabel: 'Place',
        name: 'place'
    },{
        fieldLabel: 'Status',
        name: 'status'
    },{
        fieldLabel: 'State',
        name: 'state'
    },{
        fieldLabel: 'Email',
        name: 'email'
    },{
        fieldLabel: 'Phone',
        name: 'phone'
    }]
});