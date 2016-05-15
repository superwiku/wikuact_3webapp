(function() {
	'use strict';

	angular.module('yamaApp').run(productValidator);

	function productValidator($rootScope, $translate, validationSchema) {
		$rootScope.$on('$translateChangeSuccess', validate);

		function validate() {
			validationSchema.set('product', {
				name: {
					'validations': 'required, minlength=4',
					'validate-on': 'blur',
					'messages': {
						'required': {
							'error': $translate.instant('pos.product.validation.name_required'),
							'success': 'Ok'
						},
						'minlength': {
							'error': $translate.instant('pos.product.validation.name_length'),
							'success': 'Ok'
						}
					}
				}
			});
		}
	}
})();
