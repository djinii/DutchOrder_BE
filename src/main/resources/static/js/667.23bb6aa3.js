"use strict";(self["webpackChunkv2_client"]=self["webpackChunkv2_client"]||[]).push([[667],{1667:function(t,n,e){e.r(n),e.d(n,{default:function(){return L}});var o=e(6768),i=e(4232);const c=(0,o.Lk)("hr",{class:"my-4"},null,-1),r={id:"noticeNum"},s={id:"noticeTitle"},a={id:"noticeDate"},l=(0,o.Lk)("hr",{class:"my-4"},null,-1),u={id:"noticeContent"},d=(0,o.Lk)("hr",{class:"my-4"},null,-1),h={class:"noticeButton"},k=(0,o.Lk)("button",{id:"noticeDelete",type:"button",class:"btn btn-dark me-2"},"공지사항 삭제하기",-1);function m(t,n,e,m,f,v){return(0,o.uX)(),(0,o.CE)(o.FK,null,[c,(0,o.Lk)("div",r,[(0,o.Lk)("span",null,(0,i.v_)(f.notice.nonum),1)]),(0,o.Lk)("div",s,[(0,o.Lk)("h3",null,(0,i.v_)(f.notice.notitle),1)]),(0,o.Lk)("div",a,[(0,o.Lk)("span",null,(0,i.v_)(v.formatDate(f.notice.nodate)),1)]),l,(0,o.Lk)("div",u,[(0,o.Lk)("span",null,(0,i.v_)(f.notice.nocon),1)]),d,(0,o.Lk)("div",h,[k,(0,o.Lk)("button",{id:"noticeModify",type:"button",class:"btn btn-primary",onClick:n[0]||(n[0]=t=>v.moveModify(f.notice.nonum))},"공지사항 수정하기")])],64)}e(4114);var f=e(8355),v={data(){return{notice:{}}},mounted(){this.fetchNoticeDetails()},methods:{async fetchNoticeDetails(){try{const t=await f.A.post("/JY_A_NoticeDetails",{nonum:this.$route.query.nonum});this.notice=t.data,console.log("Response:",t.data)}catch(t){console.error("Error fetching notice details:",t)}},formatDate(t){const n=new Date(t);return`${n.toISOString().slice(0,16).replace("T"," ")}`},async moveModify(t){try{this.$router.push({path:"/JY_A_NoticeModify",query:{nonum:t}})}catch(n){console.error("Error fetching noticeDetails:",n)}}}},y=e(1241);const p=(0,y.A)(v,[["render",m]]);var L=p}}]);
//# sourceMappingURL=667.23bb6aa3.js.map