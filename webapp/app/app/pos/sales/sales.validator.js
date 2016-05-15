(function() {
	'use strict';

	angular.module('yamaApp').run(salesValidator);

	function salesValidator($rootScope, $translate, validationSchema) {
		$rootScope.$on('$translateChangeSuccess', validate);

		function validate() {
			validationSchema.set('sales', {
				quantity: {
					'validations': 'required, minlength=4',
					'validate-on': 'blur',
					'messages': {
						'required': {
							'error': $translate.instant('pos.sales.validation.name_required'),
							'success': 'Ok'
						},
						'minlength': {
							'error': $translate.instant('pos.sales.validation.name_length'),
							'success': 'Ok'
						}
					}
				}
			});
		}
	}
})();
