package com.dutchOrder.server.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.Shop;
import com.dutchOrder.server.service.MsMenuService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MsMenuController {

	private final MsMenuService ms;

	// 가게 내용
	@GetMapping("/C_ShopCard")
	@ResponseBody
	public List<Shop> addShopCategoryLi() {
		System.out.println("MsMenuController Start shopCategoryLi ... ");

		List<Shop> resShopCategoryLi = ms.ShopCategoryLi();

		System.out.println("MsMenuController List Menulist.size() -> " + resShopCategoryLi.size());

		return resShopCategoryLi;

	}

	@PostMapping("/ShopStatus")
	@ResponseBody
	public Shop getShopStatus(@RequestBody Shop msShop) {
		System.out.println("MsMenuController Start ShopStatus ... ");
		System.out.println("MsMenuController getShopStatus msShop " + msShop);
		Shop shopStatus = ms.getShopStatus(msShop.getBnum()); // bnum에 해당하는 가게의 상태 조회
		System.out.println("MsMenuController ShopStatus -> " + shopStatus);

		return shopStatus;
	}

	/** 영업상태 업데이트 */
	@PostMapping("/ShopStatusUpdate")
	@ResponseBody
	public int UpdateShopStatus(@RequestBody Shop msShop) {
		System.out.println("MsMenuController Start UpdateShopStatus");
		System.out.println("MsMenuController UpdateShopStatus msShop " + msShop);
		int ShopStatusUpdate = ms.updateShopStatus(msShop);
		System.out.println("MsMenuController os.msShop msShop -> " + msShop);

		return ShopStatusUpdate;
	}

	// 메뉴 내용
	@GetMapping("/C_MRcardInf") // GET 요청을 처리할 수 있도록 수정
	@ResponseBody
	public List<Menu> addMenuList() {
		System.out.println("MsMenuController Start menuList ... ");
		List<Menu> msMenulist = ms.Menulist();
		System.out.println("MsMenuController List Menulist.size() -> " + msMenulist.size());
		return msMenulist;
	}
	
	
	@PostMapping("/B_MenuDetail")
	@ResponseBody
	public List<Menu> MenuDetail(@RequestBody Menu msMenu) {
		System.out.println("MsMenuController Start menuList ... ");
		System.out.println("MsviewController MenuDetail msMenu " + msMenu);
		int bnum = msMenu.getBnum();
		System.out.println("bnum-->"+bnum);
		List<Menu> msMenuDetail = ms.DetailMenu(bnum);
		
		System.out.println("MsMenuController MenuDetail Menulist -> " + msMenuDetail);
		return msMenuDetail;
	}
	

	// 가게 내용 번호로 가져오기
	@GetMapping("/B_ShopDetail")
	@ResponseBody
	public Shop getShopDetail(@RequestParam("mnum") int mnum) {

		System.out.println("MsMenuController Start getShopByBnum ... ");

		Shop shop = ms.ShopDetail(mnum);

		System.out.println("MsMenuController Shop info -> " + shop);

		return shop;

	}

	/** bnum에 따라 가게 운영시간 업데이트 */
	@ResponseBody
	@PostMapping("/business/Modify")
	public int ShopTimeUpdate(@RequestBody Shop msShop) {
		System.out.println("MsMenuController Start updateShopTime");
		System.out.println("MsMenuController updateShopTime msShop " + msShop);
		int TimeUpdate = ms.updateShopTimeUpdate(msShop);
		System.out.println("MsMenuController os.msShop msShop -> " + msShop);

		return TimeUpdate;
	}
	
	

	/** 메뉴 추가하기 */
	@ResponseBody
	@PostMapping("/MenuInsert")
	public int adMenuwrite(@RequestBody Menu msMenu) {
		System.out.println("MsMenuController Start adNoticeWrite...");
		System.out.println("MsMenuController adMenuwrite msMenu " + msMenu);
		int adMenuInsert = ms.adMenuInsert(msMenu);

		return adMenuInsert;
	}

	// fnum을 대한 메뉴 수정하기
	@PostMapping("/B_MenuReUpdate")
	@ResponseBody
	public int MenuReUpdate(@RequestBody Menu msMenu) {
		System.out.println("MsMenuController Start MenuReUpdate ... ");
		System.out.println("NoticeCOntroller MenuReUpdate msMenu " + msMenu);
		int reMenuUpdate = ms.reMenuUpdate(msMenu);
		System.out.println("NoticeCOntroller  ms.reMenuUpdate reMenuUpdate -> " + reMenuUpdate);
		return reMenuUpdate;
	}

	/** fnum에 대한 메뉴 삭제 */
	@ResponseBody
	@PostMapping("/B_MenuDelete")
	public int MenuDelete(@RequestBody Menu msMenu) {
		System.out.println("MsMenuController Start MenuDelete");
		System.out.println("NoticeController MenuDelete notice " + msMenu);
		int deleteMenu = ms.deleteMenu(msMenu.getFnum());

		return deleteMenu;
	}

	@PostMapping("/ShopAcceptStatus")
	@ResponseBody
	public Shop ShopAcceptStatus(@RequestBody Shop msShop) {
		System.out.println("MsMenuController Start ShopStatus ... ");
		System.out.println("MsMenuController getShopStatus msShop " + msShop);
		System.out.println("MsMenuController getShopStatus msShop " + msShop);
		Shop shopAccept = ms.getshopAccept(msShop.getMnum()); // Mnum에 해당하는 가게의 상태 조회
		System.out.println("MsMenuController ShopStatus -> " + shopAccept);

		return shopAccept;
	}

	/** 가게 등록 페이지 */
	@ResponseBody
	@PostMapping("/ShopReg")
	public int ShopReg(@RequestBody Shop msShop) {
		System.out.println("MsMenuController Start ShopReg...");
		System.out.println("MsMenuController ShopReg MsShop " + msShop);
		int RegShop = ms.RegShop(msShop);

		return RegShop;
	}
	
	
	// 가게 이름 중복 확인
    @GetMapping("/check-duplicate/sname")
    public ResponseEntity<?> checkSnameDuplicate(@RequestParam("sname") String sname){
        boolean isDuplicate = ms.issnameDuplicate(sname);
        return ResponseEntity.ok().body(Map.of("isDuplicate", isDuplicate));
    }
    
    // 사업자 번호, 중복 확인
    @GetMapping("/check-duplicate/bid")
    public ResponseEntity<?> checkBidDuplicate(@RequestParam("bid") String bid){
    	boolean isDuplicate = ms.isBidDuplicate(bid);
    	return ResponseEntity.ok().body(Map.of("isDuplicate", isDuplicate));
    }

	/** 파일 등록시 bfileDetail select */
	@ResponseBody
	@PostMapping("/BFileDetail")
	public Shop BFileSelect(@RequestBody Shop msShop) {
		System.out.println("MsMenuController Start BFileSelect ... ");
		System.out.println("MsMenuController BFileSelect msShop " + msShop);
		Shop getFileDetail = ms.getFileDetail(msShop.getMnum()); // bnum에 해당하는 가게의 상태 조회
		System.out.println("MsMenuController BFileSelect -> " + getFileDetail);

		return getFileDetail;
	}

	/** 파일 등록시 */
	@ResponseBody
	@PostMapping("/BFileInsert")
	public int BFileInsert(@RequestBody Shop msShop) {
		System.out.println("MsMenuController Start BFileSelect ... ");
		System.out.println("MsMenuController BFileSelect msShop " + msShop);
		int InsertBfile = ms.InsertBfile(msShop);

		return InsertBfile;
	}


}