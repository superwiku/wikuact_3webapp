(function() {
	'use strict';

	angular.module('yamaApp').run(purchaseValidator);

	function purchaseValidator($rootScope, $translate, validationSchema) {
		$rootScope.$on('$translateChangeSuccess', validate);

		function validate() {
			validationSchema.set('purchase', {
				name: {
					'validations': 'required, minlength=1',
					'validate-on': 'blur',
					'messages': {
						'required': {
							'error': $translate.instant('pos.purchase.validation.name_required'),
							'success': 'Ok'
						},
						'minlength': {
							'error': $translate.instant('pos.purchase.validation.name_length'),
							'success': 'Ok'
						}
					}
				}
			});
		}
	}
})();
