var exec = require('cordova/exec');
var PLUGIN_NAME = 'Zoomable';

var zoomable = {

	enable : function (success, error ) {
		exec(success, error, 'Zoomable', 'enable', []);
	},
	disable : function (success, error ) {
		exec(success, error, 'Zoomable', 'disable', []);
	},
	enablecontrols : function (success, error ) {
		exec(success, error, 'Zoomable', 'enablecontrols', []);
	},
	disablecontrols : function (success, error ) {
		exec(success, error, 'Zoomable', 'disablecontrols', []);
	}
};

module.exports = zoomable;
