/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libpadel;

import com.jidesoft.grid.Property;
import com.jidesoft.swing.JideSwingUtilities;

/**
 *
 * @author phayapc
 */
public class PaDELDoubleProperty extends Property
{
    private Object value_;

    public PaDELDoubleProperty(String name, String description, String category)
    {
	super(name, description, Double.class, category);
    }

    public PaDELDoubleProperty(String name, String description, String category, Double defaultValue)
    {
	super(name, description, Double.class, category);
	setValue(defaultValue);
    }

    @Override
    public void setValue(Object value)
    {
	Object old = getValue();
	if (!JideSwingUtilities.equals(old, value))
	{
	    value_ = value;
	    firePropertyChange(PROPERTY_VALUE, old, value);
	}
    }

    @Override
    public Object getValue()
    {
	return value_;
    }

}
