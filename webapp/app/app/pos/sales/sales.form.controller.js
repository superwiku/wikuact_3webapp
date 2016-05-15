(function() {
	'use strict';

	angular.module('yamaApp').controller('PosSalesFormCtrl', salesFormController);

	function salesFormController($modalInstance, $validation, changeSecret, sales, RestSalesService) {
		// jshint validthis: true
		var ctrl = this;
		ctrl.sales = sales;
		ctrl.submit = submitSales;

		function error() {
			ctrl.error = true;
		}

		function submitSales(sales, form) {
			$validation.validate(form).success(submit);

			function submit() {
				ctrl.error = false;

				if (sales.id) {
					sales.put().then(success, error);
				} else {
					RestSalesService.post(sales).then(success, error);
				}
			}
		}

		
		function success(sales) {
			$modalInstance.close(sales);
		}
	}
})();
