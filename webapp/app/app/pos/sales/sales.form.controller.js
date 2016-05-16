(function() {
	'use strict';

	angular.module('yamaApp').controller('PosSalesFormCtrl', salesFormController);

	function salesFormController($modalInstance, $validation, changeSecret, sales, RestSalesService, RestProductService) {
		// jshint validthis: true
		var ctrl = this;
		ctrl.sales = sales;
		ctrl.submit = submitSales;
		ctrl.loadProducts = loadProducts;
		ctrl.loadProduct = loadProduct;
		ctrl.calculateTotalsales = calculateTotalsales;
	

		function loadProducts(search) {
			RestProductService.getList({ q: search }).then(onProductsLoaded);

			function onProductsLoaded(products) {
				ctrl.products = products;
			}
		}

		function loadProduct(product) {
			ctrl.product = product;
		}

		function calculateTotalsales (qty) {
			ctrl.sales.totalsales = qty * ctrl.product.price;
		}

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