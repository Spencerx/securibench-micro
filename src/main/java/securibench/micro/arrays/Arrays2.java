/*
   Copyright 2006 Benjamin Livshits

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Arrays2.java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package securibench.micro.arrays;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import securibench.micro.BasicTestCase;
import securibench.micro.MicroTestCase;

import javax.persistence.EntityManager;

/** 
 *  @servlet description = "a more complex array test" 
 *  @servlet vuln_count = "1" 
 *  */
public class Arrays2 extends BasicTestCase implements MicroTestCase {

    EntityManager em;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String s1 = req.getParameter("name");
        String[] array = new String[10];
        array[0] = s1;

        em.createQuery(array[0]);         /* BAD */
        em.createQuery(array[1]);         /* OK */
        em.createQuery(array[2]);         /* OK */
    }
    
    public String getDescription() {
        return "a more complex array test";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}