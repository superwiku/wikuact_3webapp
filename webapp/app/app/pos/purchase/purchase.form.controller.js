(function() {
	'use strict';

	angular.module('yamaApp').controller('PosPurchaseFormCtrl', purchaseFormController);

	function purchaseFormController($modalInstance, $validation, changeSecret, purchase, RestPurchaseService, RestProductService) {
		// jshint validthis: true
		var ctrl = this;
		ctrl.purchase = purchase;
		ctrl.submit = submitPurchase;
		ctrl.loadProducts = loadProducts;
		ctrl.loadProduct = loadProduct;
		ctrl.calculateTotalpurchase = calculateTotalpurchase;
	

		function loadProducts(search) {
			RestProductService.getList({ q: search }).then(onProductsLoaded);

			function onProductsLoaded(products) {
				ctrl.products = products;
			}
		}

		function loadProduct(product) {
			ctrl.product = product;
		}

		function calculateTotalpurchase (qty) {
			ctrl.purchase.totalpurchase = qty * ctrl.product.price;
		}

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