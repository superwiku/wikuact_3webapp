(function() {
	'use strict';

	angular.module('yamaApp').controller('PosSalesListCtrl', salesListController);

	function salesListController($location, $modal, angularPopupBoxes, RestSalesService) {
		// jshint validthis: true
		var ctrl = this;
		ctrl.openForm = openSalesForm;
		ctrl.page = 1;
		ctrl.remove = removeSales;
		ctrl.searchParams = $location.search();
		ctrl.searchParams.hash = 0;
		ctrl.search = searchSaless;
		ctrl.search();

		function onSalessLoaded(saless) {
			ctrl.saless = saless;
			ctrl.page = saless.meta.number + 1;
		}

		function openSalesForm(sales, changeSecret) {
			var modal = $modal.open({
				templateUrl: 'app/pos/sales/sales.form.html',
				controller: 'PosSalesFormCtrl as ctrl',
				size: 'md',
				resolve: {
					sales: function() { return sales; },
					changeSecret: function() { return changeSecret; }
				}
			});

			modal.result.then(success);

			function success(result) {
				ctrl.searchParams.q = result.name;
				ctrl.search();
			}
		}

		function removeSales(sales) {
			angularPopupBoxes.confirm('Are you sure want to delete this data?')
					.result.then(remove);

			function remove() {
				sales.remove().then(ctrl.search);
			}
		}

		function searchSaless() {
			ctrl.searchParams.hash++;
			ctrl.searchParams.page = ctrl.page - 1;

			$location.search(ctrl.searchParams);

			RestSalesService.getList(ctrl.searchParams).then(onSalessLoaded);
		}
	}
})();
