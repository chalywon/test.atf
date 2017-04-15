package tools;


import java.io.File;

/*
 * Copyright 2016 charl.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 * @author charl
 */
public class UpdatePicture {
    public static void main(String[] args){
       File file=new File("C:\\Users\\charl\\证照1031\\新增导入");
       File[] files=file.listFiles();
       for(File f:files)
       {
           String fileName=f.getName();
           int dot=fileName.lastIndexOf('.');
           String fileTemp=fileName.substring(0,dot);
           String store_id=fileTemp.substring(0, fileTemp.length()-2);
           String licence=fileTemp.substring(fileTemp.length()-2,fileTemp.length());
           String sql="update shopnc_store_register";
           if(licence.equals("01"))
               sql+=" set business_licence_number_elc='"+fileName+"' where store_reg_id='"+store_id+"';";
           else
               sql+=" set food_licence='"+fileName+"' where store_reg_id='"+store_id+"';";
           System.out.println(sql);
       }
    }
    
}
