/*
* extjspoc.modal.Employee
* Model for the Employee.
*/
Ext.define('extjspoc.model.Employee', {
	extend: 'Ext.data.Model',
	fields: [
		'employeeId',
		{name: 'name', type:'string'},
		{name: 'place', type: 'string'},
		{name: 'status', type: 'string'},
		{name: 'state', type: 'string'},
		{name: 'email', type: 'string'},
		{name: 'phone', type: 'string'}
	],
	idProperty: 'employeeId'

});