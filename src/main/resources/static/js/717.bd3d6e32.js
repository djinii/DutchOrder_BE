"use strict";(self["webpackChunkv2_client"]=self["webpackChunkv2_client"]||[]).push([[717],{8986:function(a,t,n){n.d(t,{A:function(){return L}});var e=n(6768),s=n(4232);const c=a=>((0,e.Qi)("data-v-ec792b34"),a=a(),(0,e.jt)(),a),r={class:"card h-100"},o={class:"col"},d={class:"card h-100"},l={class:"card-body d-flex align-items-center"},i=c((()=>(0,e.Lk)("div",{class:"StoreImg"},null,-1))),u={class:"ml-3",style:{"margin-left":"20px"}},m={class:"card-title mb-0"},v={class:"card-text"},p=c((()=>(0,e.Lk)("p",{class:"card-text"},"최소주문 100원 부터",-1)));function h(a,t,n,c,h,f){const k=(0,e.g2)("router-link");return(0,e.uX)(!0),(0,e.CE)(e.FK,null,(0,e.pI)(h.shopInfo,(a=>((0,e.uX)(),(0,e.CE)("div",{key:a.bnum},[(0,e.bF)(k,{to:{name:"C_ShopInf",params:{id:a.bnum}}},{default:(0,e.k6)((()=>[(0,e.Lk)("div",r,[(0,e.Lk)("div",o,[(0,e.Lk)("div",d,[(0,e.Lk)("div",l,[i,(0,e.Lk)("div",u,[(0,e.Lk)("h5",m,(0,s.v_)(a.sname),1),(0,e.Lk)("p",v," 운영시간 : "+(0,s.v_)(a.start_time)+" ~ "+(0,s.v_)(a.end_time),1),p])])])])])])),_:2},1032,["to"])])))),128)}var f=n(8355),k={name:"C_ShopCard",data(){return{shopInfo:[]}},mounted(){this.fetchData()},methods:{async fetchData(){await f.A.get("http://localhost:8888/C_ShopCard").then((a=>{this.shopInfo=a.data})).catch((a=>{console.error("Error fetching menu data:",a)}))}}},_=n(1241);const C=(0,_.A)(k,[["render",h],["__scopeId","data-v-ec792b34"]]);var L=C},2717:function(a,t,n){n.r(t),n.d(t,{default:function(){return p}});var e=n(6768),s=n(727);const c=a=>((0,e.Qi)("data-v-3919fa2a"),a=a(),(0,e.jt)(),a),r={class:"container"},o=c((()=>(0,e.Lk)("div",{class:"text-center mb-4"},[(0,e.Lk)("div",{class:"image-wrapper"},[(0,e.Lk)("img",{src:s,alt:""})]),(0,e.Lk)("h1",{class:"mt-3"},"일식 페이지")],-1))),d={class:"row row-cols-1 row-cols-md-3 g-4"};function l(a,t,n,s,c,l){const i=(0,e.g2)("C_ShopCard");return(0,e.uX)(),(0,e.CE)("div",r,[o,(0,e.Lk)("div",d,[((0,e.uX)(!0),(0,e.CE)(e.FK,null,(0,e.pI)(a.menus,(a=>((0,e.uX)(),(0,e.Wv)(i,{key:a.id,menu:a},null,8,["menu"])))),128))])])}var i=n(8986),u={name:"C_Menu",components:{C_ShopCard:i.A}},m=n(1241);const v=(0,m.A)(u,[["render",l],["__scopeId","data-v-3919fa2a"]]);var p=v},727:function(a,t,n){a.exports=n.p+"img/Jfood.628a292b.png"}}]);
//# sourceMappingURL=717.bd3d6e32.js.map