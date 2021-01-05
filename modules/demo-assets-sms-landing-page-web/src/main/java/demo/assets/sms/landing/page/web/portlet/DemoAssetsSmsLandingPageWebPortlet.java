package demo.assets.sms.landing.page.web.portlet;

import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.UUIDItemSelectorReturnType;
import com.liferay.layout.item.selector.criterion.LayoutItemSelectorCriterion;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.user.groups.admin.item.selector.UserGroupItemSelectorCriterion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import demo.assets.sms.landing.page.web.constants.DemoAssetsSmsLandingPageWebPortletKeys;

/**
 * @author dfrancisco
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DemoAssetsSmsLandingPageWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DemoAssetsSmsLandingPageWebPortletKeys.DEMOASSETSSMSLANDINGPAGEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DemoAssetsSmsLandingPageWebPortlet extends MVCPortlet {

	@Reference(unbind = "-")
	public void setItemSelector(ItemSelector itemSelector) {
		this.itemSelector = itemSelector;
	}
	
	@Override
		public void render(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
		
		LayoutItemSelectorCriterion layoutItemSelectorCriterion = new LayoutItemSelectorCriterion();
		List<ItemSelectorReturnType> desiredItemSelectorReturnTypes = new ArrayList<ItemSelectorReturnType>();
		desiredItemSelectorReturnTypes.add(new URLItemSelectorReturnType());
		layoutItemSelectorCriterion.setDesiredItemSelectorReturnTypes(desiredItemSelectorReturnTypes);
		PortletURL itemSelectorURL = itemSelector.getItemSelectorURL(RequestBackedPortletURLFactoryUtil.create(renderRequest), "selectLayoutEvent", layoutItemSelectorCriterion);
		
		UserGroupItemSelectorCriterion userGroupItemSelectorCriterion = new UserGroupItemSelectorCriterion();
		List<ItemSelectorReturnType> userGroupItemSelectorReturnTypes = new ArrayList<ItemSelectorReturnType>();
		userGroupItemSelectorReturnTypes.add(new UUIDItemSelectorReturnType());
		userGroupItemSelectorCriterion.setDesiredItemSelectorReturnTypes(userGroupItemSelectorReturnTypes);
		PortletURL userGroupitemSelectorURL = itemSelector.getItemSelectorURL(RequestBackedPortletURLFactoryUtil.create(renderRequest), "selectUserGroupEvent", userGroupItemSelectorCriterion);

		renderRequest.setAttribute("itemSelectorURL", itemSelectorURL.toString());
		renderRequest.setAttribute("userGroupitemSelector", userGroupitemSelectorURL.toString());
			super.render(renderRequest, renderResponse);
		}
	
	
	private ItemSelector itemSelector;
}