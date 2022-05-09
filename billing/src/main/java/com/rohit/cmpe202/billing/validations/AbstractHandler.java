package com.rohit.cmpe202.billing.validations;
import java.util.List;
import com.rohit.cmpe202.billing.models.InputItems;

public abstract class AbstractHandler {
	protected AbstractHandler next = null;
	public abstract void nextHandler(AbstractHandler next) ;
	public abstract void handle(List<InputItems> inputItems);
}
