package demo.assets.sms.landing.page.web.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import demo.assets.sms.landing.page.web.constants.DemoAssetsSmsLandingPageWebPortletKeys;
import demo.assets.sms.service.api.DemoAssetsSmsService;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + DemoAssetsSmsLandingPageWebPortletKeys.DEMOASSETSSMSLANDINGPAGEWEB,
			"mvc.command.name=sendSMS"
		},
		service = MVCActionCommand.class
	)
public class SendSMSMVCActionCommand extends BaseMVCActionCommand {
	
	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String smsText  = ParamUtil.getString(
				actionRequest, "smsText");
		
		String selectedLayout  = ParamUtil.getString(
				actionRequest, "selectedLayout");
		System.out.println("Selected Layout:"+selectedLayout);
		demoAssetsSmsService.sendSMS(smsText);
		
		sendRedirect(actionRequest, actionResponse);
	}
	
	@Reference 
	DemoAssetsSmsService demoAssetsSmsService;
	
}
