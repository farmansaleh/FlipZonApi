package com.flipzon.utility;

import org.springframework.stereotype.Component;
import com.flipzon.dto.Constant;

/**
 * @author Farman Saleh
 * @since 13/01/2024
 *
 */

@Component
public class FlipZonUtility {

	//return status message
	public static String getStatusMessage(int status) {
		if(Constant.ACTIVE == status) {
			return "Activated";
		}else {
			return "De-Activated";
		}
	}
	
}
