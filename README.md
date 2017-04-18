## freetoast简介
类别：Toast公共组件  

提供如下功能：  
1.  修改显示时长   
2.  修改背景色    
3.  修改文字大小，颜色    
4.  支持自定义字体    
5.  支持上下左右显示icon    
6.  待续

<img src="https://github.com/zhujian1989/freetoast/blob/master/screenshot/1.png" width="200"> <img src="https://github.com/zhujian1989/freetoast/blob/master/screenshot/2.png" width="200"> <img src="https://github.com/zhujian1989/freetoast/blob/master/screenshot/3.png" width="200">
<img src="https://github.com/zhujian1989/freetoast/blob/master/screenshot/4.png" width="200"><img src="https://github.com/zhujian1989/freetoast/blob/master/screenshot/5.png" width="200">

## 基本用法
1.  普通toast  
`FreeToast.toastShort(this,msg).show();
`  

2.  修改文字大小颜色以及字体 
` FreeToast.toastWithOutIcon(this,msg,Toast.LENGTH_SHORT,textSize,textColor,tintColor,typeface).show();
`   
3.  文字带icon 
` FreeToast.toastWithIcon(this, msg, Toast.LENGTH_SHORT, drawable, FreeToastUtils.DRAWABLE_LEFT).show();
`   
4.  全属性自定义 
` FreeToast.toastAllAttr(this, msg, Toast.LENGTH_SHORT, drawable, FreeToastUtils.DRAWABLE_TOP,textSize,textColor,tintColor,typeface).show();
`   
## License

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.





