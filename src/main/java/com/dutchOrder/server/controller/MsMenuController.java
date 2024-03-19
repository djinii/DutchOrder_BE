package com.dutchOrder.server.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.MsMenu;
import com.dutchOrder.server.model.MsShop;
import com.dutchOrder.server.service.MsMenuService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class MsMenuController {

	private final MsMenuService ms;

	// 가게 내용
	@GetMapping("/C_ShopCard")
	@ResponseBody
	public List<MsShop> addShopCategoryLi() {
		System.out.println("MsMenuController Start shopCategoryLi ... ");

		List<MsShop> resShopCategoryLi = ms.ShopCategoryLi();

		System.out.println("MsMenuController List Menulist.size() -> " + resShopCategoryLi.size());

		return resShopCategoryLi;

	}

	@PostMapping("/ShopStatus")
	@ResponseBody
	public MsShop getShopStatus(@RequestBody MsShop msShop) {
		System.out.println("MsMenuController Start ShopStatus ... ");
		System.out.println("MsMenuController getShopStatus msShop " + msShop);
		MsShop shopStatus = ms.getShopStatus(msShop.getBnum()); // bnum에 해당하는 가게의 상태 조회
		System.out.println("MsMenuController ShopStatus -> " + shopStatus);

		return shopStatus;
	}

	/** 영업상태 업데이트 */
	@PostMapping("/ShopStatusUpdate")
	@ResponseBody
	public int UpdateShopStatus(@RequestBody MsShop msShop) {
		System.out.println("MsMenuController Start UpdateShopStatus");
		System.out.println("MsMenuController UpdateShopStatus msShop " + msShop);
		int ShopStatusUpdate = ms.updateShopStatus(msShop);
		System.out.println("MsMenuController os.msShop msShop -> " + msShop);

		return ShopStatusUpdate;
	}

	// 메뉴 내용
	@GetMapping("/C_MRcardInf") // GET 요청을 처리할 수 있도록 수정
	@ResponseBody
	public List<MsMenu> addMenuList() {
		System.out.println("MsMenuController Start menuList ... ");
		List<MsMenu> msMenulist = ms.Menulist();
		System.out.println("MsMenuController List Menulist.size() -> " + msMenulist.size());
		return msMenulist;
	}

	// 가게 내용 번호로 가져오기
	@GetMapping("/B_ShopDetail")
	@ResponseBody
	public MsShop getShopDetail(@RequestParam("mnum") int mnum) {

		System.out.println("MsMenuController Start getShopByBnum ... ");

		MsShop shop = ms.ShopDetail(mnum);

		System.out.println("MsMenuController Shop info -> " + shop);

		return shop;

	}

	/** bnum에 따라 가게 운영시간 업데이트 */
	@ResponseBody
	@PostMapping("/B_ShopTimeUpdate")
	public int ShopTimeUpdate(@RequestBody MsShop msShop) {
		System.out.println("MsMenuController Start updateShopTime");
		System.out.println("MsMenuController updateShopTime msShop " + msShop);
		int TimeUpdate = ms.updateShopTimeUpdate(msShop);
		System.out.println("MsMenuController os.msShop msShop -> " + msShop);

		return TimeUpdate;
	}

	/** 메뉴 추가하기 */
	@ResponseBody
	@PostMapping("/MenuInsert")
	public int adMenuwrite(@RequestBody MsMenu msMenu) {
		System.out.println("MsMenuController Start adNoticeWrite...");
		System.out.println("MsMenuController adMenuwrite msMenu " + msMenu);
		int adMenuInsert = ms.adMenuInsert(msMenu);

		return adMenuInsert;
	}

	// 메뉴 내용
	@PostMapping("/B_MenuInfo") // GET 요청을 처리할 수 있도록 수정
	@ResponseBody
	public List<MsMenu> B_MenuInfo(@RequestBody MsMenu msMenu) {
		System.out.println("MsMenuController Start B_MenuInfo ... ");
		List<MsMenu> msMenulist = ms.MenuInfo(msMenu.getBnum());
		System.out.println("MsMenuController List Menulist.size() -> " + msMenulist.size());
		return msMenulist;
	}

	// fnum을 대한 메뉴 수정하기
	@PostMapping("/B_MenuReUpdate")
	@ResponseBody
	public int MenuReUpdate(@RequestBody MsMenu msMenu) {
		System.out.println("MsMenuController Start MenuReUpdate ... ");
		System.out.println("NoticeCOntroller MenuReUpdate msMenu " + msMenu);
		int reMenuUpdate = ms.reMenuUpdate(msMenu);
		System.out.println("NoticeCOntroller  ms.reMenuUpdate reMenuUpdate -> " + reMenuUpdate);
		return reMenuUpdate;
	}

	/** fnum에 대한 메뉴 삭제 */
	@ResponseBody
	@PostMapping("/B_MenuDelete")
	public int MenuDelete(@RequestBody MsMenu msMenu) {
		System.out.println("MsMenuController Start MenuDelete");
		System.out.println("NoticeController MenuDelete notice " + msMenu);
		int deleteMenu = ms.deleteMenu(msMenu.getFnum());

		return deleteMenu;
	}

	@PostMapping("/ShopAcceptStatus")
	@ResponseBody
	public MsShop ShopAcceptStatus(@RequestBody MsShop msShop) {
		System.out.println("MsMenuController Start ShopStatus ... ");
		System.out.println("MsMenuController getShopStatus msShop " + msShop);
		System.out.println("MsMenuController getShopStatus msShop " + msShop);
		MsShop shopAccept = ms.getshopAccept(msShop.getMnum()); // Mnum에 해당하는 가게의 상태 조회
		System.out.println("MsMenuController ShopStatus -> " + shopAccept);

		return shopAccept;
	}

	/** 가게 등록 페이지 */
	@ResponseBody
	@PostMapping("/ShopReg")
	public int ShopReg(@RequestBody MsShop msShop) {
		System.out.println("MsMenuController Start ShopReg...");
		System.out.println("MsMenuController ShopReg MsShop " + msShop);
		int RegShop = ms.RegShop(msShop);

		return RegShop;
	}

	/** 파일 등록시 bfileDetail select */
	@ResponseBody
	@PostMapping("/BFileDetail")
	public MsShop BFileSelect(@RequestBody MsShop msShop) {
		System.out.println("MsMenuController Start BFileSelect ... ");
		System.out.println("MsMenuController BFileSelect msShop " + msShop);
		MsShop getFileDetail = ms.getFileDetail(msShop.getMnum()); // bnum에 해당하는 가게의 상태 조회
		System.out.println("MsMenuController BFileSelect -> " + getFileDetail);

		return getFileDetail;
	}

	/** 파일 등록시 */
	@ResponseBody
	@PostMapping("/BFileInsert")
	public int BFileInsert(@RequestBody MsShop msShop) {
		System.out.println("MsMenuController Start BFileSelect ... ");
		System.out.println("MsMenuController BFileSelect msShop " + msShop);
		int InsertBfile = ms.InsertBfile(msShop);

		return InsertBfile;
	}


}