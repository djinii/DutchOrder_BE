"use strict";(self["webpackChunkv2_client"]=self["webpackChunkv2_client"]||[]).push([[231],{231:function(t,e,i){i.r(e),i.d(e,{default:function(){return m}});var o=i(6768),n=i(4232);const c=(0,o.Lk)("div",{id:"pageName"},[(0,o.Lk)("h2",null,"공지사항 -관리자-")],-1),s=(0,o.Lk)("hr",{class:"my-4"},null,-1),r={id:"noticeWrite"},l={class:"noticeList"},a={class:"d-grid gap-2 col-10 mx-auto"},u=["onClick"];function h(t,e,i,h,d,k){return(0,o.uX)(),(0,o.CE)(o.FK,null,[c,s,(0,o.Lk)("div",r,[(0,o.Lk)("button",{type:"button",class:"btn btn-primary",onClick:e[0]||(e[0]=(...t)=>k.moveWrite&&k.moveWrite(...t))},"공지사항 작성하기")]),(0,o.Lk)("div",l,[((0,o.uX)(!0),(0,o.CE)(o.FK,null,(0,o.pI)(d.listNotice,(t=>((0,o.uX)(),(0,o.CE)("div",{key:t},[(0,o.Lk)("div",a,[(0,o.Lk)("button",{class:"btn btn-outline-dark",type:"button",onClick:e=>k.moveDetails(t.nonum)},(0,n.v_)(t.notitle),9,u)])])))),128))])],64)}i(4114);var d=i(8355),k={data(){return{listNotice:[]}},mounted(){this.fetchNoticeList()},methods:{async fetchNoticeList(){try{const t=await d.A.post("/JY_A_NoticeList",{});this.listNotice=t.data,console.log("Response:",t.data)}catch(t){console.error("Error fetching noticeList:",t)}},async moveDetails(t){try{this.$router.push({path:"/JY_A_NoticeDetails",query:{nonum:t}})}catch(e){console.error("Error fetching noticeDetails:",e)}},moveWrite(){this.$router.push("/JY_A_NoticeWrite")}}},v=i(1241);const p=(0,v.A)(k,[["render",h]]);var m=p}}]);
//# sourceMappingURL=231.b6adb276.js.map