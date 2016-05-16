(function() {
	'use strict';

	angular.module('yamaApp').controller('PosCtrl', posController);

	function posController($state) {
		// jshint validthis: true
		var ctrl = this;
		ctrl.menus = [
			{ menu: 'Product', icon: 'user', ref: 'app.pos.product' },
			{ menu: 'Purchase', icon: 'users', ref: 'app.pos.purchase' },
			{ menu: 'Sales', icon: 'users', ref: 'app.pos.sales' }
		];
		ctrl.state = $state;

		if (ctrl.state.current.name === 'app.pos') {
			ctrl.state.go(ctrl.menus[0].ref);
		}
	}
})();
