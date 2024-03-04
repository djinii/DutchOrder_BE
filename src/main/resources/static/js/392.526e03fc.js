"use strict";(self["webpackChunkv2_client"]=self["webpackChunkv2_client"]||[]).push([[392],{7011:function(o,e,l){l.r(e),l.d(e,{default:function(){return X}});var s=l(6768),a=l(5130);const c={class:"container mt-5"},r=(0,s.Lk)("h2",{class:"mb-4"},"회원가입(개인)",-1),i={class:"mb-3 row"},n=(0,s.Lk)("label",{for:"name",class:"col-sm-3 col-form-label"},"이름:",-1),t={class:"col-sm-6"},d={class:"mb-3 row"},m=(0,s.Lk)("label",{for:"email",class:"col-sm-3 col-form-label"},"이메일(아이디):",-1),u={class:"col-sm-6"},b={class:"input-group"},p={class:"mb-3 row"},k=(0,s.Lk)("label",{for:"verificationCode",class:"col-sm-3 col-form-label"},"인증번호:",-1),f={class:"col-sm-6"},L={class:"input-group"},v={class:"mb-3 row"},h=(0,s.Lk)("label",{for:"password",class:"col-sm-3 col-form-label"},"비밀번호:",-1),w={class:"col-sm-6"},C={class:"mb-3 row"},y=(0,s.Lk)("label",{for:"confirmPassword",class:"col-sm-3 col-form-label"},"비밀번호 확인:",-1),V={class:"col-sm-6"},N={class:"mb-3 row"},q=(0,s.Lk)("label",{for:"businessName",class:"col-sm-3 col-form-label"},"닉네임:",-1),J={class:"col-sm-6"},U={class:"input-group"},P={class:"mb-3 row"},g=(0,s.Lk)("label",{for:"phoneNumber",class:"col-sm-3 col-form-label"},"연락처:",-1),D={class:"col-sm-6"},x=(0,s.Lk)("div",{class:"mb-3 row"},[(0,s.Lk)("div",{class:"col-sm-3"}),(0,s.Lk)("div",{class:"col-sm-6"},[(0,s.Lk)("button",{type:"submit",class:"btn btn-primary"},"가입하기")])],-1);function F(o,e,l,F,A,E){return(0,s.uX)(),(0,s.CE)("div",c,[r,(0,s.Lk)("form",{onSubmit:e[10]||(e[10]=(0,a.D$)(((...o)=>E.submitForm&&E.submitForm(...o)),["prevent"]))},[(0,s.Lk)("div",i,[n,(0,s.Lk)("div",t,[(0,s.bo)((0,s.Lk)("input",{type:"text","onUpdate:modelValue":e[0]||(e[0]=o=>A.name=o),class:"form-control",id:"name",placeholder:"이름을 입력하세요",required:""},null,512),[[a.Jo,A.name]])])]),(0,s.Lk)("div",d,[m,(0,s.Lk)("div",u,[(0,s.Lk)("div",b,[(0,s.bo)((0,s.Lk)("input",{type:"email","onUpdate:modelValue":e[1]||(e[1]=o=>A.email=o),class:"form-control",id:"email",placeholder:"이메일을 입력하세요",required:""},null,512),[[a.Jo,A.email]]),(0,s.Lk)("button",{type:"button",class:"btn btn-secondary",onClick:e[2]||(e[2]=(...o)=>E.sendVerificationCode&&E.sendVerificationCode(...o))}," 이메일 인증 ")])])]),(0,s.Lk)("div",p,[k,(0,s.Lk)("div",f,[(0,s.Lk)("div",L,[(0,s.bo)((0,s.Lk)("input",{type:"text","onUpdate:modelValue":e[3]||(e[3]=o=>A.verificationCode=o),class:"form-control",id:"verificationCode",placeholder:"인증번호를 입력하세요",required:""},null,512),[[a.Jo,A.verificationCode]]),(0,s.Lk)("button",{type:"button",class:"btn btn-secondary",onClick:e[4]||(e[4]=(...o)=>E.confirmVerificationCode&&E.confirmVerificationCode(...o))}," 인증번호 확인 ")])])]),(0,s.Lk)("div",v,[h,(0,s.Lk)("div",w,[(0,s.bo)((0,s.Lk)("input",{type:"password","onUpdate:modelValue":e[5]||(e[5]=o=>A.password=o),class:"form-control",id:"password",placeholder:"비밀번호를 입력하세요",required:""},null,512),[[a.Jo,A.password]])])]),(0,s.Lk)("div",C,[y,(0,s.Lk)("div",V,[(0,s.bo)((0,s.Lk)("input",{type:"password","onUpdate:modelValue":e[6]||(e[6]=o=>A.confirmPassword=o),class:"form-control",id:"confirmPassword",placeholder:"비밀번호를 다시 입력하세요",required:""},null,512),[[a.Jo,A.confirmPassword]])])]),(0,s.Lk)("div",N,[q,(0,s.Lk)("div",J,[(0,s.Lk)("div",U,[(0,s.bo)((0,s.Lk)("input",{type:"text","onUpdate:modelValue":e[7]||(e[7]=o=>A.businessName=o),class:"form-control",id:"businessName",placeholder:"닉네임을 입력하세요",required:""},null,512),[[a.Jo,A.businessName]]),(0,s.Lk)("button",{type:"button",class:"btn btn-secondary",onClick:e[8]||(e[8]=(...o)=>E.checkDuplicate&&E.checkDuplicate(...o))}," 중복확인 ")])])]),(0,s.Lk)("div",P,[g,(0,s.Lk)("div",D,[(0,s.bo)((0,s.Lk)("input",{type:"tel","onUpdate:modelValue":e[9]||(e[9]=o=>A.phoneNumber=o),class:"form-control",id:"phoneNumber",placeholder:"연락처를 입력하세요 (예시: 010-1234-5678)",pattern:"[0-9]{3}-[0-9]{4}-[0-9]{4}",required:""},null,512),[[a.Jo,A.phoneNumber]])])]),x],32)])}var A=l(8355),E={data(){return{name:"",email:"",verificationCode:"",password:"",confirmPassword:"",businessName:"",phoneNumber:""}},methods:{submitForm(){},sendVerificationCode(){A.A.post("http://localhost:8888/sendVerificationEmail",{email:this.email}).then((o=>{alert("서버 응답: "+o.data),console.log("서버 응답:",o.data)})).catch((o=>{console.error("서버 오류:",o),alert("서버 오류 발생!")}))},confirmVerificationCode(){},checkDuplicate(){}}},_=l(1241);const S=(0,_.A)(E,[["render",F]]);var X=S}}]);
//# sourceMappingURL=392.526e03fc.js.map