<%@ include file="./init.jsp"%>

<p>
	<b><liferay-ui:message key="demoassetssmslandingpageweb.caption" /></b>
</p>

<portlet:actionURL name="sendSMS" var="sendSMSURL" />

<aui:form action="<%=sendSMSURL%>" cssClass="pt-4" method="post" name="fm">
	
	<aui:input name="smsText" label="SMS Text"/>
	<aui:input type="text" readonly="true" name="selectedLayout" value="" label="Landing Page"></aui:input>
	<aui:button name="selectLayout" value="Select" />
	<br/>
	To send an SMS click here:
	<aui:button-row>
		<aui:button cssClass="btn btn-primary" type="submit" />
	</aui:button-row>
</aui:form>

<%
String itemSelectorURL = (String)renderRequest.getAttribute("itemSelectorURL");
%>

<aui:script use="aui-base,liferay-item-selector-dialog">

var selectedLayout = A.one('#<portlet:namespace />selectedLayout');

A.one('#<portlet:namespace />selectLayout').on('click',function(event) {

var itemSelectorDialog = new A.LiferayItemSelectorDialog(
                 {
                     eventName: 'selectLayoutEvent',

                     on: {

                            selectedItemChange: function(event) {

                            var selectedItem = event.newVal;

                            if (selectedItem) {

                                selectedLayout.val(selectedItem.value);

                            }

                         }

                     },

                   title: 'Select Layout',

                   url: '<%= itemSelectorURL %>'

               });

                  itemSelectorDialog.open();

               });

</aui:script>