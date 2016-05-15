(function() {
	'use strict';

	angular.module('yamaApp').controller('PosProductListCtrl', productListController);

	function productListController($location, $modal, angularPopupBoxes, RestProductService) {
		// jshint validthis: true
		var ctrl = this;
		ctrl.openForm = openProductForm;
		ctrl.page = 1;
		ctrl.remove = removeProduct;
		ctrl.searchParams = $location.search();
		ctrl.searchParams.hash = 0;
		ctrl.search = searchProducts;
		ctrl.search();

		function onProductsLoaded(products) {

			ctrl.products = products;
			ctrl.page = products.meta.number + 1;
		}

		function openProductForm(product, changeSecret) {
			var modal = $modal.open({
				templateUrl: 'app/pos/product/product.form.html',
				controller: 'PosProductFormCtrl as ctrl',
				size: 'md',
				resolve: {
					product: function() { return product; },
					changeSecret: function() { return changeSecret; }
				}
			});

			modal.result.then(success);

			function success(result) {
				ctrl.searchParams.q = result.name;
				ctrl.search();
			}
		}

		function removeProduct(product) {
			angularPopupBoxes.confirm('Are you sure want to delete this data?')
					.result.then(remove);

			function remove() {
				product.remove().then(ctrl.search);
			}
		}

		function searchProducts() {
			ctrl.searchParams.hash++;
			ctrl.searchParams.page = ctrl.page - 1;

			$location.search(ctrl.searchParams);

			RestProductService.getList(ctrl.searchParams).then(onProductsLoaded);
		}
	}
})();
