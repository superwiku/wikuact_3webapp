(function() {
	'use strict';

	angular.module('yamaApp').controller('PosPurchaseFormCtrl', purchaseFormController);

	function purchaseFormController($modalInstance, $validation, changeSecret, purchase, RestPurchaseService, RestProductService) {
		// jshint validthis: true
		var ctrl = this;
		ctrl.purchase = purchase || {};
		ctrl.purchase.purchaseDetails = [];
		ctrl.purchaseDetail = {};
		ctrl.submit = submitPurchase;
		ctrl.loadProducts = loadProducts;
		ctrl.loadProduct = loadProduct;
		ctrl.calculateTotalpurchase = calculateTotalpurchase;
		ctrl.addPurchaseDetail = addPurchaseDetail;


		function addPurchaseDetail(product, form) {
			$validation.validate(form).success(add);

			function add() {
				var purchaseDetail = {};
				purchaseDetail.product = product;
				purchaseDetail.subtotal = calculateTotalpurchase(product.quantity, product.price);
				purchaseDetail.quantity = product.quantity;

				ctrl.purchase.purchaseDetails.push(purchaseDetail);
				ctrl.product = {};
				ctrl.total = calculateTotal(ctrl.purchase.purchaseDetails);
			}
		}

		function loadProducts(search) {
			RestProductService.getList({ q: search }).then(onProductsLoaded);
		

		function onProductsLoaded(products) {
				ctrl.products = products;
			}
		}

		function loadProduct(product) {
			ctrl.product = product;
		}

		function calculateTotalpurchase (qty, price) {
			return Number(qty) * Number(price);
		}

		function calculateTotal(purchaseDetails) {
			var total = 0;

			for (var d in purchaseDetails) {
				d = purchaseDetails[d];

				total += Number(d.subtotal);
			}

			return total;
		}

		function error() {
			ctrl.error = true;
		}

		function submitPurchase(purchase) {
			ctrl.error = false;

			if (purchase.id) {
				purchase.put().then(success, error);

			} else {
				RestPurchaseService.post(purchase.purchaseDetails).then(success, error);
			}
		}

	
		function success(purchase) {
			$modalInstance.close(purchase);
		}
	}
})();