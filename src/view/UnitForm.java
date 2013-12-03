package view;


import java.util.List;

import model.Unit;

public class UnitForm {
	private Unit unit;
    private Unit supUnit;
    private List<Unit> units;
    private List<Unit> subUnits;

    public List<Unit> getUnits() {
            return units;
    }

    public void setUnits(List<Unit> units) {
            this.units = units;
    }

    public Unit getUnit() {
            return unit;
    }

    public void setUnit(Unit unit) {
            this.unit = unit;
    }

    public Unit getSupUnit() {
            return supUnit;
    }

    public void setSupUnit(Unit supUnit) {
            this.supUnit = supUnit;
    }

    public List<Unit> getSubUnits() {
            return subUnits;
    }

    public void setSubUnits(List<Unit> subUnits) {
            this.subUnits = subUnits;
    }
	
	
}
