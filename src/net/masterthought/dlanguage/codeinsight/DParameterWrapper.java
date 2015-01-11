package net.masterthought.dlanguage.codeinsight;

import net.masterthought.dlanguage.codeinsight.dcd.completions.Completion;
import net.masterthought.dlanguage.psi.interfaces.DCompositeElement;

import java.util.List;

public interface DParameterWrapper extends DCompositeElement {

    public List<Completion> getParameterList();

    public void setParameterList(List<Completion> items);

}
