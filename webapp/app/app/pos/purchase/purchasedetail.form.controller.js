(function() {
	'use strict';

	angular.module('yamaApp').controller('PosPurchaseDetailFormCtrl', purchaseFormController);

	function purchaseFormController($modalInstance, purchase) {
		// jshint validthis: true
		var ctrl = this;
		ctrl.purchase = purchase || {};
		
		purchase.one('details').getList().then(onPurchaseDetailsLoaded);

		function onPurchaseDetailsLoaded(purchaseDetails) {
			ctrl.purchase.details = purchaseDetails;
		}
	}
}
)();