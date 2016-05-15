(function() {
	'use strict';

	angular.module('yamaApp').controller('PosProductFormCtrl', productFormController);

	function productFormController($modalInstance, $validation, changeSecret, product, RestProductService) {
		// jshint validthis: true
		var ctrl = this;
		ctrl.product = product;
		ctrl.submit = submitProduct;

		function error() {
			ctrl.error = true;
		}

		function submitProduct(product, form) {
			$validation.validate(form).success(submit);

			function submit() {
				ctrl.error = false;

				if (product.id) {
					product.put().then(success, error);
				} else {
					RestProductService.post(product).then(success, error);
				}
			}
		}

		function success(product) {
			$modalInstance.close(product);
		}
	}
})();
