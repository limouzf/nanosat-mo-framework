/*
 *  ----------------------------------------------------------------------------
 *  Copyright (C) 2021      European Space Agency
 *                          European Space Operations Centre
 *                          Darmstadt
 *                          Germany
 *  ----------------------------------------------------------------------------
 *  System                : ESA NanoSat MO Framework
 *  ----------------------------------------------------------------------------
 *  Licensed under European Space Agency Public License (ESA-PL) Weak Copyleft – v2.4
 *  You may not use this file except in compliance with the License.
 * 
 *  Except as expressly set forth in this License, the Software is provided to
 *  You on an "as is" basis and without warranties of any kind, including without
 *  limitation merchantability, fitness for a particular purpose, absence of
 *  defects or errors, accuracy or non-infringement of intellectual property rights.
 *  
 *  See the License for the specific language governing permissions and
 *  limitations under the License. 
 *  ----------------------------------------------------------------------------
 */
package opssat.simulator.util;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Cezar Suteu
 */
public class SimulatorDeviceData implements Serializable {

    private LinkedList<ArgumentDescriptor> dataList;

    String name;

    public SimulatorDeviceData(String name) {
        this.name = name;
        this.dataList = new LinkedList<ArgumentDescriptor>();
    }

    public String getName() {
        return name;
    }

    public LinkedList<ArgumentDescriptor> getDataList() {
        return dataList;
    }

}
