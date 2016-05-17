(function() {
	'use strict';

	angular.module('yamaApp').controller('PosPurchaseListCtrl', purchaseListController);

	function purchaseListController($location, $modal, angularPopupBoxes, RestPurchaseService) {
		// jshint validthis: true
		var ctrl = this;
		ctrl.openPurchaseDetailForm = openPurchaseDetailForm;
		ctrl.openForm = openPurchaseForm;
		ctrl.page = 1;
		ctrl.remove = removePurchase;
		ctrl.searchParams = $location.search();
		ctrl.searchParams.hash = 0;
		ctrl.search = searchPurchases;
		ctrl.search();

		function onPurchasesLoaded(purchases) {
			ctrl.purchases = purchases;
			ctrl.page = purchases.meta.number + 1;
		}

		function openPurchaseDetailForm(purchase, changeSecret) {
			var modal = $modal.open({
				templateUrl: 'app/pos/purchase/purchasedetail.form.html',
				controller: 'PosPurchaseDetailFormCtrl as ctrl',
				size: 'lg',
				resolve: {
					purchase: function() { return purchase; }
					
				}
			});
															
			modal.result.then(success);

			function success(result) {
				ctrl.searchParams.q = result.name;
				ctrl.search();
			}
		}

		function openPurchaseForm(purchase, changeSecret) {
			var modal = $modal.open({
				templateUrl: 'app/pos/purchase/purchase.form.html',
				controller: 'PosPurchaseFormCtrl as ctrl',
				size: 'lg',
				resolve: {
					purchase: function() { return purchase; },
					changeSecret: function() { return changeSecret; }
				}
			});

			modal.result.then(success);

			function success(result) {
				ctrl.searchParams.q = result.name;
				ctrl.search();
			}
		}

		function removePurchase(purchase) {
			angularPopupBoxes.confirm('Are you sure want to delete this data?')
					.result.then(remove);

			function remove() {
				purchase.remove().then(ctrl.search);
			}
		}

		function searchPurchases() {
			ctrl.searchParams.hash++;
			ctrl.searchParams.page = ctrl.page - 1;

			$location.search(ctrl.searchParams);

			RestPurchaseService.getList(ctrl.searchParams).then(onPurchasesLoaded);
		}
	}
})();
