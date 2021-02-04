package commerce.demo.wislisht.service.override;

import com.liferay.commerce.wish.list.service.CommerceWishListItemService;
import com.liferay.commerce.wish.list.service.CommerceWishListItemServiceWrapper;
import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author dfrancisco
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class CommerceDemoWislishtServiceOverride extends CommerceWishListItemServiceWrapper {

	public CommerceDemoWislishtServiceOverride() {
		super(null);
	}
	
	
	
	@Reference(unbind = "-")
	private void serviceSetter(CommerceWishListItemService commerceWishListItemService) {
	    setWrappedService(commerceWishListItemService);
	}

}