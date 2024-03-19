"use strict";(self["webpackChunkv2_client"]=self["webpackChunkv2_client"]||[]).push([[449],{449:function(e,t,s){s.r(t),s.d(t,{default:function(){return Y}});var a=s(6768);const l={class:"container mt-5"},i=(0,a.Lk)("h2",{class:"mb-4"},"가게 등록",-1),o={key:0,class:"alert alert-info"},n={key:1,class:"alert alert-info"},m={key:2,class:"alert alert-success"};function r(e,t,s,r,u,c){const d=(0,a.g2)("B_ShopReg"),g=(0,a.g2)("B_FileInsert");return(0,a.uX)(),(0,a.CE)("div",l,[i,c.shouldShowFileRegistrationSection?((0,a.uX)(),(0,a.CE)("div",o,[(0,a.bF)(d,{mnum:e.getUserMnum},null,8,["mnum"])])):u.shopStatus&&500===u.shopStatus.bstaus_mikey?((0,a.uX)(),(0,a.CE)("div",n," 가게 등록 승인 중입니다. ")):u.shopStatus&&502===u.shopStatus.bstaus_mikey?((0,a.uX)(),(0,a.CE)("div",m," 가게 등록이 승인 되었습니다. ")):(0,a.Q3)("",!0),c.shouldShowFileInsertSection?((0,a.uX)(),(0,a.Wv)(g,{key:3,mnum:e.getUserMnum},null,8,["mnum"])):(0,a.Q3)("",!0)])}var u=s(8355),c=s(782),d=s(5130);const g={class:"mb-3"},h=(0,a.Lk)("label",{for:"sname",class:"form-label"},"식당명",-1),b={class:"mb-3"},k=(0,a.Lk)("label",{for:"fcategory_mikey",class:"form-label"},"가게 분류",-1),p=(0,a.Lk)("option",{value:"301"},"한식",-1),f=(0,a.Lk)("option",{value:"302"},"중식",-1),y=(0,a.Lk)("option",{value:"303"},"일식",-1),v=(0,a.Lk)("option",{value:"304"},"분식",-1),L=[p,f,y,v],_={class:"mb-3"},F=(0,a.Lk)("label",{for:"saddr",class:"form-label"},"주소",-1),w={class:"mb-3"},U=(0,a.Lk)("label",{for:"stel",class:"form-label"},"전화번호",-1),R={class:"mb-3"},S=(0,a.Lk)("label",{for:"bid",class:"form-label"},"사업자번호",-1),x={class:"mb-3"},A=(0,a.Lk)("label",{for:"start_time",class:"form-label"},"운영시간 시작",-1),C={class:"mb-3"},I=(0,a.Lk)("label",{for:"end_time",class:"form-label"},"운영시간 종료",-1),z={id:"reviewImg",class:"custom-file"},B=(0,a.Lk)("label",{class:"custom-file-label",for:"customFile"},[(0,a.Lk)("svg",{xmlns:"http://www.w3.org/2000/svg",width:"50",height:"50",fill:"currentColor",class:"bi bi-card-image",viewBox:"0 0 16 16"},[(0,a.Lk)("path",{d:"M6.002 5.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0"}),(0,a.Lk)("path",{d:"M1.5 2A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2zm13 1a.5.5 0 0 1 .5.5v6l-3.775-1.947a.5.5 0 0 0-.577.093l-3.71 3.71-2.66-1.772a.5.5 0 0 0-.63.062L1.002 12v.54L1 12.5v-9a.5.5 0 0 1 .5-.5z"})])],-1),M={id:"imagePreview"},X=["src"];function E(e,t,s,l,i,o){return(0,a.uX)(),(0,a.CE)("div",null,[(0,a.Lk)("div",g,[h,(0,a.bo)((0,a.Lk)("input",{type:"text","onUpdate:modelValue":t[0]||(t[0]=e=>i.sname=e),class:"form-control",id:"sname"},null,512),[[d.Jo,i.sname]])]),(0,a.Lk)("div",b,[k,(0,a.bo)((0,a.Lk)("select",{"onUpdate:modelValue":t[1]||(t[1]=e=>i.fcategory_mikey=e),class:"form-select",id:"fcategory_mikey"},L,512),[[d.u1,i.fcategory_mikey]])]),(0,a.Lk)("div",_,[F,(0,a.bo)((0,a.Lk)("input",{type:"text","onUpdate:modelValue":t[2]||(t[2]=e=>i.saddr=e),class:"form-control",id:"saddr"},null,512),[[d.Jo,i.saddr]])]),(0,a.Lk)("div",w,[U,(0,a.bo)((0,a.Lk)("input",{type:"text","onUpdate:modelValue":t[3]||(t[3]=e=>i.stel=e),class:"form-control",id:"stel"},null,512),[[d.Jo,i.stel]])]),(0,a.Lk)("div",R,[S,(0,a.bo)((0,a.Lk)("input",{type:"text","onUpdate:modelValue":t[4]||(t[4]=e=>i.bid=e),class:"form-control",id:"bid"},null,512),[[d.Jo,i.bid]])]),(0,a.Lk)("div",x,[A,(0,a.bo)((0,a.Lk)("input",{type:"text","onUpdate:modelValue":t[5]||(t[5]=e=>i.start_time=e),class:"form-control",id:"start_time"},null,512),[[d.Jo,i.start_time]])]),(0,a.Lk)("div",C,[I,(0,a.bo)((0,a.Lk)("input",{type:"text","onUpdate:modelValue":t[6]||(t[6]=e=>i.end_time=e),class:"form-control",id:"end_time"},null,512),[[d.Jo,i.end_time]])]),(0,a.Lk)("div",z,[(0,a.Lk)("input",{id:"customFile",type:"file",ref:"image",onChange:t[7]||(t[7]=(...e)=>o.upload&&o.upload(...e))},null,544),B]),(0,a.Lk)("div",M,[i.imageUrl?((0,a.uX)(),(0,a.CE)("img",{key:0,src:i.imageUrl,class:"rounded mx-auto d-block",style:{"max-width":"100%","max-height":"300px"}},null,8,X)):(0,a.Q3)("",!0)]),(0,a.Lk)("button",{onClick:t[8]||(t[8]=(...e)=>o.submitRegistrationForm&&o.submitRegistrationForm(...e)),class:"btn btn-primary"}," 가게 등록 ")])}var D={name:"B_ShopReg",props:["mnum"],data(){return{sname:"",fcategory_mikey:"301",saddr:"",stel:"",start_time:"",end_time:"",imageUrl:null,simg1:null,bid:""}},mounted(){console.log("Received mnum:",this.mnum)},methods:{async upload(){if(this.image=this.$refs.image.files[0],console.log(this.image),!this.image)return;const e=new FileReader;e.onload=e=>{this.imageUrl=e.target.result},e.readAsDataURL(this.image)},async submitRegistrationForm(){try{const e={bnum:this.bnum,sname:this.sname,fcategory_mikey:this.fcategory_mikey,saddr:this.saddr,stel:this.stel,start_time:this.start_time,end_time:this.end_time,simg1:this.imageUrl,simg2:null,simg3:null,sconfirm:null,mnum:this.mnum,fcategory_makey:300,sstatus_makey:400,sstatus_mikey:400,bstaus_makey:500,bstaus_mikey:500,bid:this.bid};this.imageUrl&&(e.simg1=this.imageUrl),console.log("formData->"+e);const t=await u.A.post("/ShopReg",e);console.log("가게 등록 완료:",t.data),alert("가게가 성공적으로 등록되었습니다.")}catch(e){console.error("가게 등록 오류:",e),alert("가게 등록에 실패했습니다.")}}}},V=s(1241);const J=(0,V.A)(D,[["render",E]]);var Q=J;const P={id:"bizRegFileImg",class:"custom-file"},$=(0,a.Lk)("label",{for:"bizRegFileImg"},"사업자등록증",-1),O=(0,a.Lk)("label",{class:"custom-file-label",for:"customFile"},[(0,a.Lk)("svg",{xmlns:"http://www.w3.org/2000/svg",width:"50",height:"50",fill:"currentColor",class:"bi bi-card-image",viewBox:"0 0 16 16"},[(0,a.Lk)("path",{d:"M6.002 5.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0"}),(0,a.Lk)("path",{d:"M1.5 2A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2zm13 1a.5.5 0 0 1 .5.5v6l-3.775-1.947a.5.5 0 0 0-.577.093l-3.71 3.71-2.66-1.772a.5.5 0 0 0-.63.062L1.002 12v.54L1 12.5v-9a.5.5 0 0 1 .5-.5z"})])],-1),W={id:"bizRegImagePreview"},j=["src"];function q(e,t,s,l,i,o){return(0,a.uX)(),(0,a.CE)("div",null,[(0,a.Lk)("div",P,[$,(0,a.Lk)("input",{id:"customFile",type:"file",ref:"image",onChange:t[0]||(t[0]=(...e)=>o.upload&&o.upload(...e))},null,544),O]),(0,a.Lk)("div",W,[i.bizRegImageUrl?((0,a.uX)(),(0,a.CE)("img",{key:0,src:i.bizRegImageUrl,class:"rounded mx-auto d-block",style:{"max-width":"100%","max-height":"300px"}},null,8,j)):(0,a.Q3)("",!0)]),(0,a.Lk)("button",{onClick:t[1]||(t[1]=(...e)=>o.submitForm&&o.submitForm(...e)),class:"btn btn-primary"},"업로드")])}s(4114);var G={name:"B_FileInsert",props:["mnum"],data(){return{bizRegImage:null,bizRegImageUrl:null}},methods:{async upload(){if(this.image=this.$refs.image.files[0],console.log(this.image),!this.image)return;const e=new FileReader;e.onload=e=>{this.bizRegImageUrl=e.target.result},e.readAsDataURL(this.image)},async submitForm(){try{const e={mnum:this.mnum,bfnum:this.mnum,bftype_makey:600,bftype_mikey:601,bfimg1:this.bizRegImageUrl};console.log("formData->"+e);const t=await u.A.post("/BFileInsert",e);console.log("파일 등록 완료:",t.data),alert("파일 등록 완료 되었습니다. 2~3일 정도 확인할 시간이 소요됩니다."),this.$router.push("/business/B_Ordering")}catch(e){console.error("파일 등록 오류:",e),alert("파일 등록에 실패했습니다.")}}}};const H=(0,V.A)(G,[["render",q]]);var K=H,N={name:"B_Files",components:{B_ShopReg:Q,B_FileInsert:K},data(){return{shopStatus:{},bFiles:{}}},mounted(){this.fetchData(),console.log("User Mnum:",this.getUserMnum)},computed:{...(0,c.L8)(["getUserMnum"]),shouldShowFileRegistrationSection(){return!this.shopStatus||!this.shopStatus.bstaus_mikey||!this.getUserMnum},shouldShowFileInsertSection(){return!this.bFiles||!this.bFiles.bfnum}},methods:{async fetchData(){try{const e=this.getUserMnum,[t,s]=await Promise.all([u.A.post("/ShopAcceptStatus",{mnum:e}),u.A.post("/BFileDetail",{mnum:e})]);this.shopStatus=t.data,this.bFiles=s.data,console.log("상태:",this.shopStatus),console.log("파일 상태:",this.bFiles.bfnum)}catch(e){console.error("데이터를 불러오는 중 오류 발생:",e)}}}};const T=(0,V.A)(N,[["render",r]]);var Y=T}}]);
//# sourceMappingURL=449.5b57290e.js.map