(function() {
	'use strict';

	angular.module('yamaApp').controller('PosPurchaseFormCtrl', purchaseFormController);

	function purchaseFormController($modalInstance, $validation, changeSecret, purchase, RestPurchaseService) {
		// jshint validthis: true
		var ctrl = this;
		ctrl.purchase = purchase;
		ctrl.submit = submitPurchase;

		function error() {
			ctrl.error = true;
		}

		function submitPurchase(purchase, form) {
			$validation.validate(form).success(submit);

			function submit() {
				ctrl.error = false;

				if (purchase.id) {
					purchase.put().then(success, error);
				} else {
					RestPurchaseService.post(purchase).then(success, error);
				}
			}
		}

		function success(purchase) {
			$modalInstance.close(purchase);
		}
	}
})();
