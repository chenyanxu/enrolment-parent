<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<?mso-application progid="Word.Document"?>
<pkg:package xmlns:pkg="http://schemas.microsoft.com/office/2006/xmlPackage">
	<pkg:part pkg:name="/_rels/.rels" pkg:contentType="application/vnd.openxmlformats-package.relationships+xml" pkg:padding="512">
		<pkg:xmlData>
			<Relationships xmlns="http://schemas.openxmlformats.org/package/2006/relationships">
				<Relationship Id="rId3" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/extended-properties" Target="docProps/app.xml"/>
				<Relationship Id="rId2" Type="http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties" Target="docProps/core.xml"/>
				<Relationship Id="rId1" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument" Target="word/document.xml"/>
			</Relationships>
		</pkg:xmlData>
	</pkg:part>
	<pkg:part pkg:name="/word/_rels/document.xml.rels" pkg:contentType="application/vnd.openxmlformats-package.relationships+xml" pkg:padding="256">
		<pkg:xmlData>
			<Relationships xmlns="http://schemas.openxmlformats.org/package/2006/relationships">
				<Relationship Id="rId3" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/webSettings" Target="webSettings.xml"/>
				<Relationship Id="rId2" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/settings" Target="settings.xml"/>
				<Relationship Id="rId1" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles" Target="styles.xml"/>
				<Relationship Id="rId5" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme" Target="theme/theme1.xml"/>
				<Relationship Id="rId4" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/fontTable" Target="fontTable.xml"/>
			</Relationships>
		</pkg:xmlData>
	</pkg:part>
	<pkg:part pkg:name="/word/document.xml" pkg:contentType="application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml">
		<pkg:xmlData>
			<w:document mc:Ignorable="w14 w15 wp14" xmlns:wpc="http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas" xmlns:mc="http://schemas.openxmlformats.org/markup-compatibility/2006" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:r="http://schemas.openxmlformats.org/officeDocument/2006/relationships" xmlns:m="http://schemas.openxmlformats.org/officeDocument/2006/math" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:wp14="http://schemas.microsoft.com/office/word/2010/wordprocessingDrawing" xmlns:wp="http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing" xmlns:w10="urn:schemas-microsoft-com:office:word" xmlns:w="http://schemas.openxmlformats.org/wordprocessingml/2006/main" xmlns:w14="http://schemas.microsoft.com/office/word/2010/wordml" xmlns:w15="http://schemas.microsoft.com/office/word/2012/wordml" xmlns:wpg="http://schemas.microsoft.com/office/word/2010/wordprocessingGroup" xmlns:wpi="http://schemas.microsoft.com/office/word/2010/wordprocessingInk" xmlns:wne="http://schemas.microsoft.com/office/word/2006/wordml" xmlns:wps="http://schemas.microsoft.com/office/word/2010/wordprocessingShape">
				<w:body>
					<w:p w:rsidR="00D911A4" w:rsidRDefault="008C131C">
						<#assign questionType1 = ""/>
						<#assign questionStem1 = ""/>
						<#assign questionType2 = ""/>
						<#assign questionStem2 = ""/>
						<#list quesList as ques>
							<#list (ques.question)! as question>
								<#if question_index = 0>
									<#assign questionType1 = "${(kskm?html)!}"/>
									<#assign questionStem1 = "${(question.stem?html)!}"/>
								</#if>
								<#if question_index = 1>
									<#assign questionType2 = "${(kskm?html)!}"/>
									<#assign questionStem2 = "${(question.stem?html)!}"/>
									<#break>
								</#if>
							</#list>
						</#list>
						<w:r w:rsidR="004E3488">
							<w:rPr>
								<w:noProof/>
							</w:rPr>
							<mc:AlternateContent>
								<mc:Choice Requires="wps">
									<w:drawing>
										<wp:anchor distT="45720" distB="45720" distL="114300" distR="114300" simplePos="0" relativeHeight="251659264" behindDoc="0" locked="0" layoutInCell="1" allowOverlap="1" wp14:anchorId="3E07B49D" wp14:editId="48A8CB2B">
											<wp:simplePos x="0" y="0"/>
											<wp:positionH relativeFrom="column">
												<wp:posOffset>29845</wp:posOffset>
											</wp:positionH>
											<wp:positionV relativeFrom="paragraph">
												<wp:posOffset>429</wp:posOffset>
											</wp:positionV>
											<wp:extent cx="2261870" cy="437871"/>
											<wp:effectExtent l="0" t="0" r="0" b="635"/>
											<wp:wrapSquare wrapText="bothSides"/>
											<wp:docPr id="217" name="文本框 2"/>
											<wp:cNvGraphicFramePr>
												<a:graphicFrameLocks xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main"/>
											</wp:cNvGraphicFramePr>
											<a:graphic xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main">
												<a:graphicData uri="http://schemas.microsoft.com/office/word/2010/wordprocessingShape">
													<wps:wsp>
														<wps:cNvSpPr txBox="1">
															<a:spLocks noChangeArrowheads="1"/>
														</wps:cNvSpPr>
														<wps:spPr bwMode="auto">
														<a:xfrm>
															<a:off x="0" y="0"/>
															<a:ext cx="2261870" cy="437871"/>
														</a:xfrm>
														<a:prstGeom prst="rect">
															<a:avLst/>
														</a:prstGeom>
														<a:noFill/>
														<a:ln w="9525">
															<a:noFill/>
															<a:miter lim="800000"/>
															<a:headEnd/>
															<a:tailEnd/>
														</a:ln>
														</wps:spPr>
														<wps:txbx>
															<w:txbxContent>
																<w:p w:rsidR="00793991" w:rsidRPr="00CB703B" w:rsidRDefault="00793991">
																	<w:pPr>
																		<w:rPr>
																			<w:rFonts w:asciiTheme="majorEastAsia" w:eastAsiaTheme="majorEastAsia" w:hAnsiTheme="majorEastAsia"/>
																			<w:b/>
																			<w:sz w:val="30"/>
																			<w:szCs w:val="30"/>
																		</w:rPr>
																	</w:pPr>
																	<w:r w:rsidRPr="00CB703B">
																		<w:rPr>
																			<w:rFonts w:asciiTheme="majorEastAsia" w:eastAsiaTheme="majorEastAsia" w:hAnsiTheme="majorEastAsia" w:hint="eastAsia"/>
																			<w:b/>
																			<w:sz w:val="30"/>
																			<w:szCs w:val="30"/>
																		</w:rPr>
																		<w:t>${questionType1!}</w:t>
																	</w:r>
																</w:p>
															</w:txbxContent>
														</wps:txbx>
														<wps:bodyPr rot="0" vert="horz" wrap="square" lIns="91440" tIns="45720" rIns="91440" bIns="45720" anchor="t" anchorCtr="0">
															<a:noAutofit/>
														</wps:bodyPr>
													</wps:wsp>
												</a:graphicData>
											</a:graphic>
											<wp14:sizeRelH relativeFrom="margin">
												<wp14:pctWidth>0</wp14:pctWidth>
											</wp14:sizeRelH>
											<wp14:sizeRelV relativeFrom="margin">
												<wp14:pctHeight>0</wp14:pctHeight>
											</wp14:sizeRelV>
										</wp:anchor>
									</w:drawing>
								</mc:Choice>
								<mc:Fallback>
									<w:pict>
										<v:shape w14:anchorId="3E07B49D" id="_x0000_s1029" type="#_x0000_t202" style="position:absolute;left:0;text-align:left;margin-left:2.35pt;margin-top:.05pt;width:178.1pt;height:34.5pt;z-index:251659264;visibility:visible;mso-wrap-style:square;mso-width-percent:0;mso-height-percent:0;mso-wrap-distance-left:9pt;mso-wrap-distance-top:3.6pt;mso-wrap-distance-right:9pt;mso-wrap-distance-bottom:3.6pt;mso-position-horizontal:absolute;mso-position-horizontal-relative:text;mso-position-vertical:absolute;mso-position-vertical-relative:text;mso-width-percent:0;mso-height-percent:0;mso-width-relative:margin;mso-height-relative:margin;v-text-anchor:top" o:gfxdata="UEsDBBQABgAIAAAAIQC2gziS/gAAAOEBAAATAAAAW0NvbnRlbnRfVHlwZXNdLnhtbJSRQU7DMBBF&#xA;90jcwfIWJU67QAgl6YK0S0CoHGBkTxKLZGx5TGhvj5O2G0SRWNoz/78nu9wcxkFMGNg6quQqL6RA&#xA;0s5Y6ir5vt9lD1JwBDIwOMJKHpHlpr69KfdHjyxSmriSfYz+USnWPY7AufNIadK6MEJMx9ApD/oD&#xA;OlTrorhX2lFEilmcO2RdNtjC5xDF9pCuTyYBB5bi6bQ4syoJ3g9WQ0ymaiLzg5KdCXlKLjvcW893&#xA;SUOqXwnz5DrgnHtJTxOsQfEKIT7DmDSUCaxw7Rqn8787ZsmRM9e2VmPeBN4uqYvTtW7jvijg9N/y&#xA;JsXecLq0q+WD6m8AAAD//wMAUEsDBBQABgAIAAAAIQA4/SH/1gAAAJQBAAALAAAAX3JlbHMvLnJl&#xA;bHOkkMFqwzAMhu+DvYPRfXGawxijTi+j0GvpHsDYimMaW0Yy2fr2M4PBMnrbUb/Q94l/f/hMi1qR&#xA;JVI2sOt6UJgd+ZiDgffL8ekFlFSbvV0oo4EbChzGx4f9GRdb25HMsYhqlCwG5lrLq9biZkxWOiqY&#xA;22YiTra2kYMu1l1tQD30/bPm3wwYN0x18gb45AdQl1tp5j/sFB2T0FQ7R0nTNEV3j6o9feQzro1i&#xA;OWA14Fm+Q8a1a8+Bvu/d/dMb2JY5uiPbhG/ktn4cqGU/er3pcvwCAAD//wMAUEsDBBQABgAIAAAA&#xA;IQCfPWfGHgIAAPwDAAAOAAAAZHJzL2Uyb0RvYy54bWysU82O0zAQviPxDpbvNE223Xajpqtll0VI&#xA;y4+08ACu4zQWtsfYbpPyAPAGnLhw57n6HIydtlRwQ+Rg2RnPN/N983lx3WtFtsJ5Caai+WhMiTAc&#xA;amnWFf3w/v7ZnBIfmKmZAiMquhOeXi+fPll0thQFtKBq4QiCGF92tqJtCLbMMs9boZkfgRUGgw04&#xA;zQIe3TqrHesQXausGI8vsw5cbR1w4T3+vRuCdJnwm0bw8LZpvAhEVRR7C2l1aV3FNVsuWLl2zLaS&#xA;H9pg/9CFZtJg0RPUHQuMbJz8C0pL7sBDE0YcdAZNI7lIHJBNPv6DzWPLrEhcUBxvTzL5/wfL32zf&#xA;OSLrihb5jBLDNA5p/+3r/vvP/Y8vpIgCddaXeO/R4s3QP4ceB53IevsA/KMnBm5bZtbixjnoWsFq&#xA;bDCPmdlZ6oDjI8iqew011mGbAAmob5yO6qEeBNFxULvTcEQfCMefRXGZz2cY4hibXMzms6EEK4/Z&#xA;1vnwUoAmcVNR
											h8NP6Gz74EPshpXHK7GYgXupVDKAMqSr6NW0mKaEs4iWAf2ppK7ofBy/wTGR5AtT&#xA;p+TApBr2WECZA+tIdKAc+lWfFL44irmCeocyOBjsiM8HNy24z5R0aMWK+k8b5gQl6pVBKa/yySR6&#xA;Nx0m01mBB3ceWZ1HmOEIVdFAybC9DcnvA+UblLyRSY04m6GTQ8tosSTS4TlED5+f063fj3b5CwAA&#xA;//8DAFBLAwQUAAYACAAAACEASighi9kAAAAFAQAADwAAAGRycy9kb3ducmV2LnhtbEyOy07DMBBF&#xA;90j8gzVI7KhdKIGETCoEYguiPCR203iaRMTjKHab8Pe4K1jeh+495Xp2vTrwGDovCMuFAcVSe9tJ&#xA;g/D+9nRxCypEEku9F0b44QDr6vSkpML6SV75sImNSiMSCkJoYxwKrUPdsqOw8ANLynZ+dBSTHBtt&#xA;R5rSuOv1pTGZdtRJemhp4IeW6+/N3iF8PO++PlfmpXl018PkZ6PF5Rrx/Gy+vwMVeY5/ZTjiJ3So&#xA;EtPW78UG1SOsblLxaKsUXmUmB7VFyPIl6KrU/+mrXwAAAP//AwBQSwECLQAUAAYACAAAACEAtoM4&#xA;kv4AAADhAQAAEwAAAAAAAAAAAAAAAAAAAAAAW0NvbnRlbnRfVHlwZXNdLnhtbFBLAQItABQABgAI&#xA;AAAAIQA4/SH/1gAAAJQBAAALAAAAAAAAAAAAAAAAAC8BAABfcmVscy8ucmVsc1BLAQItABQABgAI&#xA;AAAAIQCfPWfGHgIAAPwDAAAOAAAAAAAAAAAAAAAAAC4CAABkcnMvZTJvRG9jLnhtbFBLAQItABQA&#xA;BgAIAAAAIQBKKCGL2QAAAAUBAAAPAAAAAAAAAAAAAAAAAHgEAABkcnMvZG93bnJldi54bWxQSwUG&#xA;AAAAAAQABADzAAAAfgUAAAAA&#xA;" filled="f" stroked="f">
											<v:textbox>
												<w:txbxContent>
													<w:p w:rsidR="00793991" w:rsidRPr="00CB703B" w:rsidRDefault="00793991">
														<w:pPr>
															<w:rPr>
																<w:rFonts w:asciiTheme="majorEastAsia" w:eastAsiaTheme="majorEastAsia" w:hAnsiTheme="majorEastAsia"/>
																<w:b/>
																<w:sz w:val="30"/>
																<w:szCs w:val="30"/>
															</w:rPr>
														</w:pPr>
														<w:r w:rsidRPr="00CB703B">
															<w:rPr>
																<w:rFonts w:asciiTheme="majorEastAsia" w:eastAsiaTheme="majorEastAsia" w:hAnsiTheme="majorEastAsia" w:hint="eastAsia"/>
																<w:b/>
																<w:sz w:val="30"/>
																<w:szCs w:val="30"/>
															</w:rPr>
															<w:t>${questionType1!}</w:t>
														</w:r>
													</w:p>
												</w:txbxContent>
											</v:textbox>
											<w10:wrap type="square"/>
										</v:shape>
									</w:pict>
								</mc:Fallback>
							</mc:AlternateContent>
						</w:r>
						<w:r>
							<w:rPr>
								<w:noProof/>
							</w:rPr>
							<mc:AlternateContent>
								<mc:Choice Requires="wps">
									<w:drawing>
										<wp:anchor distT="45720" distB="45720" distL="114300" distR="114300" simplePos="0" relativeHeight="251661312" behindDoc="0" locked="0" layoutInCell="1" allowOverlap="1" wp14:anchorId="21F315B8" wp14:editId="0594F1AA">
											<wp:simplePos x="0" y="0"/>
											<wp:positionH relativeFrom="column">
												<wp:posOffset>83185</wp:posOffset>
											</wp:positionH>
											<wp:positionV relativeFrom="paragraph">
												<wp:posOffset>448945</wp:posOffset>
											</wp:positionV>
											<wp:extent cx="5116195" cy="3699510"/>
											<wp:effectExtent l="0" t="0" r="0" b="0"/>
											<wp:wrapSquare wrapText="bothSides"/>
											<wp:docPr id="1" name="文本框 2"/>
											<wp:cNvGraphicFramePr>
												<a:graphicFrameLocks xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main"/>
											</wp:cNvGraphicFramePr>
											<a:graphic xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main">
												<a:graphicData uri="http://schemas.microsoft.com/office/word/2010/wordprocessingShape">
													<wps:wsp>
														<wps:cNvSpPr txBox="1">
															<a:spLocks noChangeArrowheads="1"/>
														</wps:cNvSpPr>
														<wps:spPr bwMode="auto">
															<a:xfrm>
																<a:off x="0" y="0"/>
																<a:ext cx="5116195" cy="3699510"/>
															</a:xfrm>
															<a:prstGeom prst="rect">
																<a:avLst/>
															</a:prstGeom>
															<a:noFill/>
															<a:ln w="9525">
																<a:noFill/>
																<a:miter lim="800000"/>
																<a:headEnd/>
																<a:tailEnd/>
															</a:ln>
														</wps:spPr>
														<wps:txbx>
															<w:txbxContent>
																<w:p w:rsidR="008C131C" w:rsidRPr="008C131C" w:rsidRDefault="008C131C" w:rsidP="008C131C">
																	<w:pPr>
																		<w:rPr>
																			<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体"/>
																			<w:bCs/>
																			<w:szCs w:val="21"/>
																		</w:rPr>
																	</w:pPr>
																	<w:r w:rsidRPr="008C131C">
																		<w:rPr>
																			<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体" w:hint="eastAsia"/>
																			<w:bCs/>
																			<w:szCs w:val="21"/>
																		</w:rPr>
																		<w:t>题目：${questionStem1!}</w:t>
																	</w:r>
																</w:p>
															</w:txbxContent>
														</wps:txbx>
														<wps:bodyPr rot="0" vert="horz" wrap="square" lIns="91440" tIns="45720" rIns="91440" bIns="45720" anchor="ctr" anchorCtr="0">
															<a:noAutofit/>
														</wps:bodyPr>
													</wps:wsp>
												</a:graphicData>
											</a:graphic>
											<wp14:sizeRelH relativeFrom="margin">
												<wp14:pctWidth>0</wp14:pctWidth>
											</wp14:sizeRelH>
											<wp14:sizeRelV relativeFrom="margin">
												<wp14:pctHeight>0</wp14:pctHeight>
											</wp14:sizeRelV>
										</wp:anchor>
									</w:drawing>
								</mc:Choice>
								<mc:Fallback>
									<w:pict>
										<v:shape w14:anchorId="21F315B8" id="_x0000_s1028" type="#_x0000_t202" style="position:absolute;left:0;text-align:left;margin-left:6.55pt;margin-top:35.35pt;width:402.85pt;height:291.3pt;z-index:251661312;visibility:visible;mso-wrap-style:square;mso-width-percent:0;mso-height-percent:0;mso-wrap-distance-left:9pt;mso-wrap-distance-top:3.6pt;mso-wrap-distance-right:9pt;mso-wrap-distance-bottom:3.6pt;mso-position-horizontal:absolute;mso-position-horizontal-relative:text;mso-position-vertical:absolute;mso-position-vertical-relative:text;mso-width-percent:0;mso-height-percent:0;mso-width-relative:margin;mso-height-relative:margin;v-text-anchor:middle" o:gfxdata="UEsDBBQABgAIAAAAIQC2gziS/gAAAOEBAAATAAAAW0NvbnRlbnRfVHlwZXNdLnhtbJSRQU7DMBBF&#xA;90jcwfIWJU67QAgl6YK0S0CoHGBkTxKLZGx5TGhvj5O2G0SRWNoz/78nu9wcxkFMGNg6quQqL6RA&#xA;0s5Y6ir5vt9lD1JwBDIwOMJKHpHlpr69KfdHjyxSmriSfYz+USnWPY7AufNIadK6MEJMx9ApD/oD&#xA;OlTrorhX2lFEilmcO2RdNtjC5xDF9pCuTyYBB5bi6bQ4syoJ3g9WQ0ymaiLzg5KdCXlKLjvcW893&#xA;SUOqXwnz5DrgnHtJTxOsQfEKIT7DmDSUCaxw7Rqn8787ZsmRM9e2VmPeBN4uqYvTtW7jvijg9N/y&#xA;JsXecLq0q+WD6m8AAAD//wMAUEsDBBQABgAIAAAAIQA4/SH/1gAAAJQBAAALAAAAX3JlbHMvLnJl&#xA;bHOkkMFqwzAMhu+DvYPRfXGawxijTi+j0GvpHsDYimMaW0Yy2fr2M4PBMnrbUb/Q94l/f/hMi1qR&#xA;JVI2sOt6UJgd+ZiDgffL8ekFlFSbvV0oo4EbChzGx4f9GRdb25HMsYhqlCwG5lrLq9biZkxWOiqY&#xA;22YiTra2kYMu1l1tQD30/bPm3wwYN0x18gb45AdQl1tp5j/sFB2T0FQ7R0nTNEV3j6o9feQzro1i&#xA;OWA14Fm+Q8a1a8+Bvu/d/dMb2JY5uiPbhG/ktn4cqGU/er3pcvwCAAD//wMAUEsDBBQABgAIAAAA&#xA;IQB+phR7HgIAAP0DAAAOAAAAZHJzL2Uyb0RvYy54bWysU82O0zAQviPxDpbvNE1pyiZqulp2WYS0&#xA;/EgLD+A6TmNhe4ztNikPAG/AiQt3nqvPwdjplgpuiBwsT2bmm/m+GS8vB63ITjgvwdQ0n0wpEYZD&#xA;I82mph/e3z65oMQHZhqmwIia7oWnl6vHj5a9rcQMOlCNcARBjK96W9MuBFtlmeed0MxPwAqDzhac&#xA;ZgFNt8kax3pE1yqbTaeLrAfXWAdceI9/b0YnXSX8thU8vG1bLwJRNcXeQjpdOtfxzFZLVm0cs53k&#xA;xzbYP3ShmTRY9AR1wwIjWyf/gtKSO/DQhgkHnUHbSi4SB2STT/9gc98xKxIXFMfbk0z+/8HyN7t3&#xA;jsgGZ0eJYRpHdPj29fD95+HHFzKL8vTWVxh1bzEuDM9hiKGRqrd3wD96YuC6Y2YjrpyDvhOswfby&#xA;mJmdpY44PoKs+9fQYB22DZCAhtbpCIhqEETHMe1PoxFDIBx/Fnm+yMuCEo6+p4uyLPI0vIxVD+nW&#xA;+fBSg
											CbxUlOHs0/wbHfnQ2yHVQ8hsZqBW6lUmr8ypK9pWcyKlHDm0TLgeiqpa3oxjd+4MJHlC9Ok&#xA;5MCkGu9YQJkj7ch05ByG9ZAEPqm5hmaPOjgYtxFfD146cJ8p6XETa+o/bZkTlKhXBrUs8/k8rm4y&#xA;5sWzGRru3LM+9zDDEaqmPDhKRuM6pIUfSV+h6q1MesTxjL0cm8YdSzId30Nc4nM7Rf1+tatfAAAA&#xA;//8DAFBLAwQUAAYACAAAACEA3hlGq94AAAAJAQAADwAAAGRycy9kb3ducmV2LnhtbEyPQUvEMBSE&#xA;74L/ITzBi7hpLbalNl1EWJBFD67+gNfmbVO2SUqT7dZ/7/Okx2GGmW/q7WpHsdAcBu8UpJsEBLnO&#xA;68H1Cr4+d/cliBDRaRy9IwXfFGDbXF/VWGl/cR+0HGIvuMSFChWYGKdKytAZshg2fiLH3tHPFiPL&#xA;uZd6xguX21E+JEkuLQ6OFwxO9GKoOx3OVsGdmZL3t+Nru9N5Z077gIVd9krd3qzPTyAirfEvDL/4&#xA;jA4NM7X+7HQQI+ss5aSCIilAsF+mJV9pFeSPWQayqeX/B80PAAAA//8DAFBLAQItABQABgAIAAAA&#xA;IQC2gziS/gAAAOEBAAATAAAAAAAAAAAAAAAAAAAAAABbQ29udGVudF9UeXBlc10ueG1sUEsBAi0A&#xA;FAAGAAgAAAAhADj9If/WAAAAlAEAAAsAAAAAAAAAAAAAAAAALwEAAF9yZWxzLy5yZWxzUEsBAi0A&#xA;FAAGAAgAAAAhAH6mFHseAgAA/QMAAA4AAAAAAAAAAAAAAAAALgIAAGRycy9lMm9Eb2MueG1sUEsB&#xA;Ai0AFAAGAAgAAAAhAN4ZRqveAAAACQEAAA8AAAAAAAAAAAAAAAAAeAQAAGRycy9kb3ducmV2Lnht&#xA;bFBLBQYAAAAABAAEAPMAAACDBQAAAAA=&#xA;" filled="f" stroked="f">
											<v:textbox>
												<w:txbxContent>
													<w:p w:rsidR="008C131C" w:rsidRPr="008C131C" w:rsidRDefault="008C131C" w:rsidP="008C131C">
														<w:pPr>
															<w:rPr>
																<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体"/>
																<w:bCs/>
																<w:szCs w:val="21"/>
															</w:rPr>
														</w:pPr>
														<w:r w:rsidRPr="008C131C">
															<w:rPr>
																<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体" w:hint="eastAsia"/>
																<w:bCs/>
																<w:szCs w:val="21"/>
															</w:rPr>
															<w:t>题目：${questionStem1!}</w:t>
														</w:r>
													</w:p>
												</w:txbxContent>
											</v:textbox>
											<w10:wrap type="square"/>
										</v:shape>
									</w:pict>
								</mc:Fallback>
							</mc:AlternateContent>
						</w:r>
						<w:r>
							<w:rPr>
								<w:noProof/>
							</w:rPr>
							<mc:AlternateContent>
								<mc:Choice Requires="wps">
									<w:drawing>
										<wp:anchor distT="45720" distB="45720" distL="114300" distR="114300" simplePos="0" relativeHeight="251658239" behindDoc="0" locked="0" layoutInCell="1" allowOverlap="1" wp14:anchorId="0E870C30" wp14:editId="6DEB3F90">
											<wp:simplePos x="0" y="0"/>
											<wp:positionH relativeFrom="column">
												<wp:posOffset>-1905</wp:posOffset>
											</wp:positionH>
											<wp:positionV relativeFrom="paragraph">
												<wp:posOffset>4785360</wp:posOffset>
											</wp:positionV>
											<wp:extent cx="2360930" cy="411480"/>
											<wp:effectExtent l="0" t="0" r="0" b="0"/>
											<wp:wrapSquare wrapText="bothSides"/>
											<wp:docPr id="3" name="文本框 2"/>
											<wp:cNvGraphicFramePr>
												<a:graphicFrameLocks xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main"/>
											</wp:cNvGraphicFramePr>
											<a:graphic xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main">
												<a:graphicData uri="http://schemas.microsoft.com/office/word/2010/wordprocessingShape">
													<wps:wsp>
														<wps:cNvSpPr txBox="1">
															<a:spLocks noChangeArrowheads="1"/>
														</wps:cNvSpPr>
														<wps:spPr bwMode="auto">
															<a:xfrm>
																<a:off x="0" y="0"/>
																<a:ext cx="2360930" cy="411480"/>
															</a:xfrm>
															<a:prstGeom prst="rect">
																<a:avLst/>
															</a:prstGeom>
															<a:noFill/>
															<a:ln w="9525">
																<a:noFill/>
																<a:miter lim="800000"/>
																<a:headEnd/>
																<a:tailEnd/>
															</a:ln>
														</wps:spPr>
														<wps:txbx>
															<w:txbxContent>
																<w:p w:rsidR="00793991" w:rsidRPr="00CB703B" w:rsidRDefault="00793991">
																	<w:pPr>
																		<w:rPr>
																			<w:rFonts w:asciiTheme="majorEastAsia" w:eastAsiaTheme="majorEastAsia" w:hAnsiTheme="majorEastAsia"/>
																			<w:b/>
																			<w:sz w:val="30"/>
																			<w:szCs w:val="30"/>
																		</w:rPr>
																	</w:pPr>
																	<w:r w:rsidRPr="00CB703B">
																		<w:rPr>
																			<w:rFonts w:asciiTheme="majorEastAsia" w:eastAsiaTheme="majorEastAsia" w:hAnsiTheme="majorEastAsia"/>
																			<w:b/>
																			<w:sz w:val="30"/>
																			<w:szCs w:val="30"/>
																		</w:rPr>
																		<w:t>${questionType2!}</w:t>
																	</w:r>
																</w:p>
															</w:txbxContent>
														</wps:txbx>
														<wps:bodyPr rot="0" vert="horz" wrap="square" lIns="91440" tIns="45720" rIns="91440" bIns="45720" anchor="t" anchorCtr="0">
															<a:noAutofit/>
														</wps:bodyPr>
													</wps:wsp>
												</a:graphicData>
											</a:graphic>
											<wp14:sizeRelH relativeFrom="margin">
												<wp14:pctWidth>40000</wp14:pctWidth>
											</wp14:sizeRelH>
											<wp14:sizeRelV relativeFrom="margin">
												<wp14:pctHeight>0</wp14:pctHeight>
											</wp14:sizeRelV>
										</wp:anchor>
									</w:drawing>
								</mc:Choice>
								<mc:Fallback>
									<w:pict>
										<v:shapetype w14:anchorId="0E870C30" id="_x0000_t202" coordsize="21600,21600" o:spt="202" path="m,l,21600r21600,l21600,xe">
											<v:stroke joinstyle="miter"/>
											<v:path gradientshapeok="t" o:connecttype="rect"/>
										</v:shapetype>
										<v:shape id="文本框 2" o:spid="_x0000_s1026" type="#_x0000_t202" style="position:absolute;left:0;text-align:left;margin-left:-.15pt;margin-top:376.8pt;width:185.9pt;height:32.4pt;z-index:251658239;visibility:visible;mso-wrap-style:square;mso-width-percent:400;mso-height-percent:0;mso-wrap-distance-left:9pt;mso-wrap-distance-top:3.6pt;mso-wrap-distance-right:9pt;mso-wrap-distance-bottom:3.6pt;mso-position-horizontal:absolute;mso-position-horizontal-relative:text;mso-position-vertical:absolute;mso-position-vertical-relative:text;mso-width-percent:400;mso-height-percent:0;mso-width-relative:margin;mso-height-relative:margin;v-text-anchor:top" o:gfxdata="UEsDBBQABgAIAAAAIQC2gziS/gAAAOEBAAATAAAAW0NvbnRlbnRfVHlwZXNdLnhtbJSRQU7DMBBF&#xA;90jcwfIWJU67QAgl6YK0S0CoHGBkTxKLZGx5TGhvj5O2G0SRWNoz/78nu9wcxkFMGNg6quQqL6RA&#xA;0s5Y6ir5vt9lD1JwBDIwOMJKHpHlpr69KfdHjyxSmriSfYz+USnWPY7AufNIadK6MEJMx9ApD/oD&#xA;OlTrorhX2lFEilmcO2RdNtjC5xDF9pCuTyYBB5bi6bQ4syoJ3g9WQ0ymaiLzg5KdCXlKLjvcW893&#xA;SUOqXwnz5DrgnHtJTxOsQfEKIT7DmDSUCaxw7Rqn8787ZsmRM9e2VmPeBN4uqYvTtW7jvijg9N/y&#xA;JsXecLq0q+WD6m8AAAD//wMAUEsDBBQABgAIAAAAIQA4/SH/1gAAAJQBAAALAAAAX3JlbHMvLnJl&#xA;bHOkkMFqwzAMhu+DvYPRfXGawxijTi+j0GvpHsDYimMaW0Yy2fr2M4PBMnrbUb/Q94l/f/hMi1qR&#xA;JVI2sOt6UJgd+ZiDgffL8ekFlFSbvV0oo4EbChzGx4f9GRdb25HMsYhqlCwG5lrLq9biZkxWOiqY&#xA;22YiTra2kYMu1l1tQD30/bPm3wwYN0x18gb45AdQl1tp5j/sFB2T0FQ7R0nTNEV3j6o9feQzro1i&#xA;OWA14Fm+Q8a1a8+Bvu/d/dMb2JY5uiPbhG/ktn4cqGU/er3pcvwCAAD//wMAUEsDBBQABgAIAAAA&#xA;IQDMjAdDGgIAAPMDAAAOAAAAZHJzL2Uyb0RvYy54bWysU82O0zAQviPxDpbvNE3aLm3UdLXssghp&#xA;+ZEWHsB1nMbC9hjbbVIeAN6AExfuPFefg7HT7VZwQ+RgeTIz38z3zXh52WtFdsJ5Caai+WhMiTAc&#xA;amk2Ff344fbZnBIfmKmZAiMquheeXq6ePll2thQFtKBq4QiCGF92tqJtCLbMMs9boZkfgRUGnQ04&#xA;zQKabpPVjnWIrlVWjMcXWQeutg648B7/3gxOukr4TSN4eNc0XgSiKoq9hXS6dK7jma2WrNw4ZlvJ&#xA;j22wf+hCM2mw6AnqhgVGtk7+BaUld+ChCSMOOoOmkVwkDsgmH//B5r5lViQuKI63J5n8/4Plb3fv&#xA;HZF1RSeUGKZxRIfv3w4/fh1+fiVFlKezvsSoe4txoX8BPY45UfX2DvgnTwxct8xsxJVz0LWC1dhe&#xA;HjOzs9QBx0eQdfcGaqzDtgESUN84HbVDNQii45j2p9GIPhCOP4vJxXgxQRdH3zTPp/M0u4yVD9nW&#xA;+fBKgCbxUlGHo0/obH
											fnQ+yGlQ8hsZiBW6lUGr8ypKvoYlbMUsKZR8uA26mkruh8HL9hXyLJl6ZO&#xA;yYFJNdyxgDJH1pHoQDn06x4DoxRrqPfI38Gwhfhq8NKC+0JJhxtYUf95y5ygRL02qOEin07jyiZj&#xA;OnteoOHOPetzDzMcoSoaKBmu1yGt+cD1CrVuZJLhsZNjr7hZSZ3jK4ire26nqMe3uvoNAAD//wMA&#xA;UEsDBBQABgAIAAAAIQBlhgJM4AAAAAkBAAAPAAAAZHJzL2Rvd25yZXYueG1sTI/NTsMwEITvSLyD&#xA;tUjcWiekaaKQTYVQOSBxoKXcXdv5gXgdxU4aeHrMCY6jGc18U+4W07NZj66zhBCvI2CapFUdNQin&#xA;t6dVDsx5QUr0ljTCl3awq66vSlEoe6GDno++YaGEXCEQWu+HgnMnW22EW9tBU/BqOxrhgxwbrkZx&#xA;CeWm53dRtOVGdBQWWjHox1bLz+NkEOrn98y8bOr9aT+l3x9zKpfXRiLe3iwP98C8XvxfGH7xAzpU&#xA;gelsJ1KO9QirJAQRsjTZAgt+ksUpsDNCHucb4FXJ/z+ofgAAAP//AwBQSwECLQAUAAYACAAAACEA&#xA;toM4kv4AAADhAQAAEwAAAAAAAAAAAAAAAAAAAAAAW0NvbnRlbnRfVHlwZXNdLnhtbFBLAQItABQA&#xA;BgAIAAAAIQA4/SH/1gAAAJQBAAALAAAAAAAAAAAAAAAAAC8BAABfcmVscy8ucmVsc1BLAQItABQA&#xA;BgAIAAAAIQDMjAdDGgIAAPMDAAAOAAAAAAAAAAAAAAAAAC4CAABkcnMvZTJvRG9jLnhtbFBLAQIt&#xA;ABQABgAIAAAAIQBlhgJM4AAAAAkBAAAPAAAAAAAAAAAAAAAAAHQEAABkcnMvZG93bnJldi54bWxQ&#xA;SwUGAAAAAAQABADzAAAAgQUAAAAA&#xA;" filled="f" stroked="f">
											<v:textbox>
												<w:txbxContent>
													<w:p w:rsidR="00793991" w:rsidRPr="00CB703B" w:rsidRDefault="00793991">
														<w:pPr>
															<w:rPr>
																<w:rFonts w:asciiTheme="majorEastAsia" w:eastAsiaTheme="majorEastAsia" w:hAnsiTheme="majorEastAsia"/>
																<w:b/>
																<w:sz w:val="30"/>
																<w:szCs w:val="30"/>
															</w:rPr>
														</w:pPr>
														<w:r w:rsidRPr="00CB703B">
															<w:rPr>
																<w:rFonts w:asciiTheme="majorEastAsia" w:eastAsiaTheme="majorEastAsia" w:hAnsiTheme="majorEastAsia"/>
																<w:b/>
																<w:sz w:val="30"/>
																<w:szCs w:val="30"/>
															</w:rPr>
															<w:t>${questionType2!}</w:t>
														</w:r>
													</w:p>
												</w:txbxContent>
											</v:textbox>
											<w10:wrap type="square"/>
										</v:shape>
									</w:pict>
								</mc:Fallback>
							</mc:AlternateContent>
						</w:r>
						<w:r>
							<w:rPr>
								<w:noProof/>
							</w:rPr>
							<mc:AlternateContent>
								<mc:Choice Requires="wps">
									<w:drawing>
										<wp:anchor distT="45720" distB="45720" distL="114300" distR="114300" simplePos="0" relativeHeight="251657214" behindDoc="0" locked="0" layoutInCell="1" allowOverlap="1" wp14:anchorId="115BC9F3" wp14:editId="095F23F5">
											<wp:simplePos x="0" y="0"/>
											<wp:positionH relativeFrom="column">
												<wp:posOffset>83185</wp:posOffset>
											</wp:positionH>
											<wp:positionV relativeFrom="paragraph">
												<wp:posOffset>5412105</wp:posOffset>
											</wp:positionV>
											<wp:extent cx="5121275" cy="3456305"/>
											<wp:effectExtent l="0" t="0" r="0" b="0"/>
											<wp:wrapSquare wrapText="bothSides"/>
											<wp:docPr id="4" name="文本框 2"/>
											<wp:cNvGraphicFramePr>
												<a:graphicFrameLocks xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main"/>
											</wp:cNvGraphicFramePr>
											<a:graphic xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main">
												<a:graphicData uri="http://schemas.microsoft.com/office/word/2010/wordprocessingShape">
													<wps:wsp>
														<wps:cNvSpPr txBox="1">
															<a:spLocks noChangeArrowheads="1"/>
														</wps:cNvSpPr>
														<wps:spPr bwMode="auto">
															<a:xfrm>
																<a:off x="0" y="0"/>
																<a:ext cx="5121275" cy="3456305"/>
															</a:xfrm>
															<a:prstGeom prst="rect">
																<a:avLst/>
															</a:prstGeom>
															<a:noFill/>
															<a:ln w="9525">
																<a:noFill/>
																<a:miter lim="800000"/>
																<a:headEnd/>
																<a:tailEnd/>
															</a:ln>
														</wps:spPr>
														<wps:txbx>
															<w:txbxContent>
																<w:p w:rsidR="008C131C" w:rsidRPr="008C131C" w:rsidRDefault="008C131C" w:rsidP="008C131C">
																	<w:pPr>
																		<w:rPr>
																			<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体"/>
																			<w:bCs/>
																			<w:szCs w:val="21"/>
																		</w:rPr>
																	</w:pPr>
																	<w:r w:rsidRPr="008C131C">
																		<w:rPr>
																			<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体" w:hint="eastAsia"/>
																			<w:bCs/>
																			<w:szCs w:val="21"/>
																		</w:rPr>
																		<w:t>题目：${questionStem2!}</w:t>
																	</w:r>
																</w:p>
															</w:txbxContent>
														</wps:txbx>
														<wps:bodyPr rot="0" vert="horz" wrap="square" lIns="91440" tIns="45720" rIns="91440" bIns="45720" anchor="ctr" anchorCtr="0">
															<a:noAutofit/>
														</wps:bodyPr>
													</wps:wsp>
												</a:graphicData>
											</a:graphic>
											<wp14:sizeRelH relativeFrom="margin">
												<wp14:pctWidth>0</wp14:pctWidth>
											</wp14:sizeRelH>
											<wp14:sizeRelV relativeFrom="margin">
												<wp14:pctHeight>0</wp14:pctHeight>
											</wp14:sizeRelV>
										</wp:anchor>
									</w:drawing>
								</mc:Choice>
								<mc:Fallback>
									<w:pict>
										<v:shape w14:anchorId="115BC9F3" id="_x0000_s1027" type="#_x0000_t202" style="position:absolute;left:0;text-align:left;margin-left:6.55pt;margin-top:426.15pt;width:403.25pt;height:272.15pt;z-index:251657214;visibility:visible;mso-wrap-style:square;mso-width-percent:0;mso-height-percent:0;mso-wrap-distance-left:9pt;mso-wrap-distance-top:3.6pt;mso-wrap-distance-right:9pt;mso-wrap-distance-bottom:3.6pt;mso-position-horizontal:absolute;mso-position-horizontal-relative:text;mso-position-vertical:absolute;mso-position-vertical-relative:text;mso-width-percent:0;mso-height-percent:0;mso-width-relative:margin;mso-height-relative:margin;v-text-anchor:middle" o:gfxdata="UEsDBBQABgAIAAAAIQC2gziS/gAAAOEBAAATAAAAW0NvbnRlbnRfVHlwZXNdLnhtbJSRQU7DMBBF&#xA;90jcwfIWJU67QAgl6YK0S0CoHGBkTxKLZGx5TGhvj5O2G0SRWNoz/78nu9wcxkFMGNg6quQqL6RA&#xA;0s5Y6ir5vt9lD1JwBDIwOMJKHpHlpr69KfdHjyxSmriSfYz+USnWPY7AufNIadK6MEJMx9ApD/oD&#xA;OlTrorhX2lFEilmcO2RdNtjC5xDF9pCuTyYBB5bi6bQ4syoJ3g9WQ0ymaiLzg5KdCXlKLjvcW893&#xA;SUOqXwnz5DrgnHtJTxOsQfEKIT7DmDSUCaxw7Rqn8787ZsmRM9e2VmPeBN4uqYvTtW7jvijg9N/y&#xA;JsXecLq0q+WD6m8AAAD//wMAUEsDBBQABgAIAAAAIQA4/SH/1gAAAJQBAAALAAAAX3JlbHMvLnJl&#xA;bHOkkMFqwzAMhu+DvYPRfXGawxijTi+j0GvpHsDYimMaW0Yy2fr2M4PBMnrbUb/Q94l/f/hMi1qR&#xA;JVI2sOt6UJgd+ZiDgffL8ekFlFSbvV0oo4EbChzGx4f9GRdb25HMsYhqlCwG5lrLq9biZkxWOiqY&#xA;22YiTra2kYMu1l1tQD30/bPm3wwYN0x18gb45AdQl1tp5j/sFB2T0FQ7R0nTNEV3j6o9feQzro1i&#xA;OWA14Fm+Q8a1a8+Bvu/d/dMb2JY5uiPbhG/ktn4cqGU/er3pcvwCAAD//wMAUEsDBBQABgAIAAAA&#xA;IQDKVHkIHwIAAP0DAAAOAAAAZHJzL2Uyb0RvYy54bWysU0tu2zAQ3RfoHQjua1mKlY9gOUiTpiiQ&#xA;foC0B6ApyiJKcliStuQeIL1BV91033P5HB1SjmO0u6JaEBzNzJt5b4bzy0ErshHOSzA1zSdTSoTh&#xA;0Eizqumnj7cvzinxgZmGKTCiplvh6eXi+bN5bytRQAeqEY4giPFVb2vahWCrLPO8E5r5CVhh0NmC&#xA;0yyg6VZZ41iP6FplxXR6mvXgGuuAC+/x783opIuE37aCh/dt60UgqqbYW0inS+cyntlizqqVY7aT&#xA;fN8G+4cuNJMGix6gblhgZO3kX1Bacgce2jDhoDNoW8lF4oBs8ukfbO47ZkXiguJ4e5DJ/z9Y/m7z&#xA;wRHZ1HRGiWEaR7T7/m3349fu5wMpojy99RVG3VuMC8NLGHDMiaq3d8A/e2LgumNmJa6cg74TrMH2&#xA;8piZHaWOOD6CLPu30GAdtg6QgIbW6agdqkEQHce0PYxGDIFw/FnmRV6clZRw9J3MytOTaZlqsOox&#xA;3To
											fXgvQJF5q6nD2CZ5t7nyI7bDqMSRWM3ArlUrzV4b0Nb0oizIlHHm0DLieSuqank/jNy5MZPnK&#xA;NCk5MKnGOxZQZk87Mh05h2E5JIGTJlGSJTRb1MHBuI34evDSgftKSY+bWFP/Zc2coES9MajlRT6b&#xA;xdVNxqw8K9Bwx57lsYcZjlA15cFRMhrXIS38SPoKVW9l0uOpl33TuGNJpv17iEt8bKeop1e7+A0A&#xA;AP//AwBQSwMEFAAGAAgAAAAhAPYM+xTfAAAACwEAAA8AAABkcnMvZG93bnJldi54bWxMj9FKw0AQ&#xA;Rd8F/2EZwRexm7QY05hNEaEgxT5Y/YBJdpoNzc6G7DaNf+/2SR8v93DnTLmZbS8mGn3nWEG6SEAQ&#xA;N0533Cr4/to+5iB8QNbYOyYFP+RhU93elFhod+FPmg6hFXGEfYEKTAhDIaVvDFn0CzcQx+7oRosh&#xA;xrGVesRLHLe9XCZJJi12HC8YHOjNUHM6nK2CBzMk+4/je73VWWNOO4/PdtopdX83v76ACDSHPxiu&#xA;+lEdquhUuzNrL/qYV2kkFeRPyxWICOTpOgNRX5t1loGsSvn/h+oXAAD//wMAUEsBAi0AFAAGAAgA&#xA;AAAhALaDOJL+AAAA4QEAABMAAAAAAAAAAAAAAAAAAAAAAFtDb250ZW50X1R5cGVzXS54bWxQSwEC&#xA;LQAUAAYACAAAACEAOP0h/9YAAACUAQAACwAAAAAAAAAAAAAAAAAvAQAAX3JlbHMvLnJlbHNQSwEC&#xA;LQAUAAYACAAAACEAylR5CB8CAAD9AwAADgAAAAAAAAAAAAAAAAAuAgAAZHJzL2Uyb0RvYy54bWxQ&#xA;SwECLQAUAAYACAAAACEA9gz7FN8AAAALAQAADwAAAAAAAAAAAAAAAAB5BAAAZHJzL2Rvd25yZXYu&#xA;eG1sUEsFBgAAAAAEAAQA8wAAAIUFAAAAAA==&#xA;" filled="f" stroked="f">
											<v:textbox>
												<w:txbxContent>
													<w:p w:rsidR="008C131C" w:rsidRPr="008C131C" w:rsidRDefault="008C131C" w:rsidP="008C131C">
														<w:pPr>
															<w:rPr>
																<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体"/>
																<w:bCs/>
																<w:szCs w:val="21"/>
															</w:rPr>
														</w:pPr>
														<w:r w:rsidRPr="008C131C">
															<w:rPr>
																<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体" w:hint="eastAsia"/>
																<w:bCs/>
																<w:szCs w:val="21"/>
															</w:rPr>
															<w:t>题目：${questionStem2!}</w:t>
														</w:r>
													</w:p>
												</w:txbxContent>
											</v:textbox>
											<w10:wrap type="square"/>
										</v:shape>
									</w:pict>
								</mc:Fallback>
							</mc:AlternateContent>
						</w:r>
						<w:r w:rsidR="00975F06">
							<w:rPr>
								<w:noProof/>
							</w:rPr>
							<mc:AlternateContent>
								<mc:Choice Requires="wps">
									<w:drawing>
										<wp:anchor distT="0" distB="0" distL="114300" distR="114300" simplePos="0" relativeHeight="251662336" behindDoc="1" locked="0" layoutInCell="1" allowOverlap="1" wp14:anchorId="53A5D267" wp14:editId="1B85991B">
											<wp:simplePos x="0" y="0"/>
											<wp:positionH relativeFrom="column">
												<wp:posOffset>-5000000</wp:posOffset>
											</wp:positionH>
											<wp:positionV relativeFrom="paragraph">
												<wp:posOffset>4351937</wp:posOffset>
											</wp:positionV>
											<wp:extent cx="8991600" cy="27940"/>
											<wp:effectExtent l="19050" t="19050" r="19050" b="29210"/>
											<wp:wrapNone/>
											<wp:docPr id="2" name="直接连接符 2"/><wp:cNvGraphicFramePr>
											<a:graphicFrameLocks xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main"/>
										</wp:cNvGraphicFramePr>
										<a:graphic xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main">
											<a:graphicData uri="http://schemas.microsoft.com/office/word/2010/wordprocessingShape">
												<wps:wsp>
													<wps:cNvCnPr>
														<a:cxnSpLocks/>
													</wps:cNvCnPr>
													<wps:spPr>
														<a:xfrm flipV="1">
															<a:off x="0" y="0"/>
															<a:ext cx="8991600" cy="27940"/>
														</a:xfrm>
														<a:prstGeom prst="line">
															<a:avLst/>
														</a:prstGeom>
														<a:ln w="28575" cap="flat" cmpd="sng">
															<a:solidFill>
																<a:srgbClr val="000000"/>
															</a:solidFill>
															<a:prstDash val="sysDot"/>
															<a:headEnd type="none" w="med" len="med"/>
															<a:tailEnd type="none" w="med" len="med"/>
														</a:ln>
													</wps:spPr>
													<wps:bodyPr/>
												</wps:wsp>
											</a:graphicData>
										</a:graphic>
										<wp14:sizeRelH relativeFrom="page">
											<wp14:pctWidth>0</wp14:pctWidth>
										</wp14:sizeRelH>
										<wp14:sizeRelV relativeFrom="page">
											<wp14:pctHeight>0</wp14:pctHeight>
										</wp14:sizeRelV>
									</wp:anchor>
								</w:drawing>
							</mc:Choice>
							<mc:Fallback>
								<w:pict>
									<v:line w14:anchorId="2623F9F0" id="直接连接符 2" o:spid="_x0000_s1026" style="position:absolute;left:0;text-align:left;flip:y;z-index:-251654144;visibility:visible;mso-wrap-style:square;mso-width-percent:0;mso-height-percent:0;mso-wrap-distance-left:9pt;mso-wrap-distance-top:0;mso-wrap-distance-right:9pt;mso-wrap-distance-bottom:0;mso-position-horizontal:absolute;mso-position-horizontal-relative:text;mso-position-vertical:absolute;mso-position-vertical-relative:text;mso-width-percent:0;mso-height-percent:0;mso-width-relative:page;mso-height-relative:page" from="-393.7pt,342.65pt" to="314.3pt,344.85pt" o:gfxdata="UEsDBBQABgAIAAAAIQC2gziS/gAAAOEBAAATAAAAW0NvbnRlbnRfVHlwZXNdLnhtbJSRQU7DMBBF&#xA;90jcwfIWJU67QAgl6YK0S0CoHGBkTxKLZGx5TGhvj5O2G0SRWNoz/78nu9wcxkFMGNg6quQqL6RA&#xA;0s5Y6ir5vt9lD1JwBDIwOMJKHpHlpr69KfdHjyxSmriSfYz+USnWPY7AufNIadK6MEJMx9ApD/oD&#xA;OlTrorhX2lFEilmcO2RdNtjC5xDF9pCuTyYBB5bi6bQ4syoJ3g9WQ0ymaiLzg5KdCXlKLjvcW893&#xA;SUOqXwnz5DrgnHtJTxOsQfEKIT7DmDSUCaxw7Rqn8787ZsmRM9e2VmPeBN4uqYvTtW7jvijg9N/y&#xA;JsXecLq0q+WD6m8AAAD//wMAUEsDBBQABgAIAAAAIQA4/SH/1gAAAJQBAAALAAAAX3JlbHMvLnJl&#xA;bHOkkMFqwzAMhu+DvYPRfXGawxijTi+j0GvpHsDYimMaW0Yy2fr2M4PBMnrbUb/Q94l/f/hMi1qR&#xA;JVI2sOt6UJgd+ZiDgffL8ekFlFSbvV0oo4EbChzGx4f9GRdb25HMsYhqlCwG5lrLq9biZkxWOiqY&#xA;22YiTra2kYMu1l1tQD30/bPm3wwYN0x18gb45AdQl1tp5j/sFB2T0FQ7R0nTNEV3j6o9feQzro1i&#xA;OWA14Fm+Q8a1a8+Bvu/d/dMb2JY5uiPbhG/ktn4cqGU/er3pcvwCAAD//wMAUEsDBBQABgAIAAAA&#xA;IQCl2FOc9AEAALYDAAAOAAAAZHJzL2Uyb0RvYy54bWysU81uEzEQviPxDpbvZJOItskqmx4ayqWC&#xA;SAXuE9ubtfCfPCabvAQvgMQNThx7521oH6NjJ6QULgixh5HtGX8z3+dvZ+dba9hGRdTeNXw0GHKm&#xA;nPBSu3XD3765fDbhDBM4CcY71fCdQn4+f/pk1odajX3njVSREYjDug8N71IKdVWh6JQFHPigHCVb&#xA;Hy0k2sZ1JSP0hG5NNR4OT6veRxmiFwqRThf7JJ8X/LZVIr1uW1SJmYbTbKnEWOIqx2o+g3odIXRa&#xA;HMaAf5jCgnbU9Ai1gATsQ9R/QFktokffpoHwtvJtq4UqHIjNaPgbm+sOgipcSBwMR5nw/8GKV5tl&#xA;ZFo2fMyZA0tPdPvp5sfHL3ffP1O8/faVjbNIfcCaai/cMmaaYuuuw5UX75Fy1aNk3mDYl23baFlr&#xA;dHhH3ij6EGO2LfLvjvKrbWKCDifT6eh0SK8kKDc+mz4vz1NBnWFy1xAxvVTesrxouNEuqwM1bK4w&#xA;5UEeSvKxcawnoMnJ2QlhArmrNZBoaQPxRbcul9EbLS+1MfkKxvXqwkS2geyX
										8mX2BPyoLPdfAHb7&#xA;Otzhwqe9lToF8oWTLO0CSenI8zwPYZXkzCj6RfKKEKFOoM3fVFJv4w4i73XNCq+83C3jT/HJHGXI&#xA;g5Gz+37dl9sPv9v8HgAA//8DAFBLAwQUAAYACAAAACEAvLuMkeEAAAAMAQAADwAAAGRycy9kb3du&#xA;cmV2LnhtbEyPwU7DMAyG70i8Q2Qkblu6DZquNJ0QE+KwExti16wJbUXjlCRru7fHO8HR9q/P319s&#xA;JtuxwfjQOpSwmCfADFZOt1hL+Di8zjJgISrUqnNoJFxMgE15e1OoXLsR382wjzUjCIZcSWhi7HPO&#xA;Q9UYq8Lc9Qbp9uW8VZFGX3Pt1Uhw2/FlkqTcqhbpQ6N689KY6nt/thLS7XDY2oUfd7ujuPwkuPoU&#xA;9ZuU93fT8xOwaKb4F4arPqlDSU4nd0YdWCdhJjLxQFmiZY8rYBRJl1kK7HTdrAXwsuD/S5S/AAAA&#xA;//8DAFBLAQItABQABgAIAAAAIQC2gziS/gAAAOEBAAATAAAAAAAAAAAAAAAAAAAAAABbQ29udGVu&#xA;dF9UeXBlc10ueG1sUEsBAi0AFAAGAAgAAAAhADj9If/WAAAAlAEAAAsAAAAAAAAAAAAAAAAALwEA&#xA;AF9yZWxzLy5yZWxzUEsBAi0AFAAGAAgAAAAhAKXYU5z0AQAAtgMAAA4AAAAAAAAAAAAAAAAALgIA&#xA;AGRycy9lMm9Eb2MueG1sUEsBAi0AFAAGAAgAAAAhALy7jJHhAAAADAEAAA8AAAAAAAAAAAAAAAAA&#xA;TgQAAGRycy9kb3ducmV2LnhtbFBLBQYAAAAABAAEAPMAAABcBQAAAAA=&#xA;" strokeweight="2.25pt">
										<v:stroke dashstyle="1 1"/>
										<o:lock v:ext="edit" shapetype="f"/>
									</v:line>
								</w:pict>
							</mc:Fallback>
						</mc:AlternateContent>
						</w:r>
					</w:p>
					<w:sectPr w:rsidR="00D911A4">
						<w:pgSz w:w="11906" w:h="16838"/>
						<w:pgMar w:top="1440" w:right="1800" w:bottom="1440" w:left="1800" w:header="851" w:footer="992" w:gutter="0"/>
						<w:cols w:space="425"/>
						<w:docGrid w:type="lines" w:linePitch="312"/>
					</w:sectPr>
				</w:body>
			</w:document>
		</pkg:xmlData>
	</pkg:part>
<pkg:part pkg:name="/word/theme/theme1.xml" pkg:contentType="application/vnd.openxmlformats-officedocument.theme+xml">
	<pkg:xmlData>
		<a:theme name="Office 主题" xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main"><a:themeElements>
			<a:clrScheme name="Office">
				<a:dk1>
					<a:sysClr val="windowText" lastClr="000000"/>
				</a:dk1>
				<a:lt1>
					<a:sysClr val="window" lastClr="FFFFFF"/>
				</a:lt1>
				<a:dk2>
					<a:srgbClr val="44546A"/>
				</a:dk2>
				<a:lt2>
					<a:srgbClr val="E7E6E6"/>
				</a:lt2>
				<a:accent1>
					<a:srgbClr val="5B9BD5"/>
				</a:accent1>
				<a:accent2>
					<a:srgbClr val="ED7D31"/>
				</a:accent2>
				<a:accent3>
					<a:srgbClr val="A5A5A5"/>
				</a:accent3>
				<a:accent4>
					<a:srgbClr val="FFC000"/>
				</a:accent4>
				<a:accent5>
					<a:srgbClr val="4472C4"/>
				</a:accent5>
				<a:accent6>
					<a:srgbClr val="70AD47"/>
				</a:accent6>
				<a:hlink>
					<a:srgbClr val="0563C1"/>
				</a:hlink>
				<a:folHlink>
					<a:srgbClr val="954F72"/>
				</a:folHlink>
			</a:clrScheme>
			<a:fontScheme name="Office">
				<a:majorFont>
					<a:latin typeface="Calibri Light"/>
					<a:ea typeface=""/>
					<a:cs typeface=""/>
					<a:font script="Hans" typeface="宋体"/><a:font script="Hebr" typeface="Times New Roman"/>
				<a:font script="Thai" typeface="Angsana New"/>
				<a:font script="Ethi" typeface="Nyala"/>
				<a:font script="Beng" typeface="Vrinda"/>
				<a:font script="Gujr" typeface="Shruti"/>
				<a:font script="Khmr" typeface="MoolBoran"/>
				<a:font script="Knda" typeface="Tunga"/>
				<a:font script="Guru" typeface="Raavi"/>
				<a:font script="Cans" typeface="Euphemia"/>
				<a:font script="Cher" typeface="Plantagenet Cherokee"/>
				<a:font script="Yiii" typeface="Microsoft Yi Baiti"/>
				<a:font script="Tibt" typeface="Microsoft Himalaya"/>
				<a:font script="Thaa" typeface="MV Boli"/>
				<a:font script="Deva" typeface="Mangal"/>
				<a:font script="Telu" typeface="Gautami"/>
				<a:font script="Taml" typeface="Latha"/>
				<a:font script="Syrc" typeface="Estrangelo Edessa"/>
				<a:font script="Orya" typeface="Kalinga"/>
				<a:font script="Mlym" typeface="Kartika"/>
				<a:font script="Laoo" typeface="DokChampa"/>
				<a:font script="Sinh" typeface="Iskoola Pota"/>
				<a:font script="Mong" typeface="Mongolian Baiti"/>
				<a:font script="Viet" typeface="Times New Roman"/>
				<a:font script="Uigh" typeface="Microsoft Uighur"/>
				<a:font script="Geor" typeface="Sylfaen"/>
			</a:majorFont>
			<a:minorFont>
				<a:latin typeface="Calibri"/>
				<a:ea typeface=""/>
				<a:cs typeface=""/>
				<a:font script="Hans" typeface="宋体"/><a:font script="Hebr" typeface="Arial"/>
			<a:font script="Thai" typeface="Cordia New"/>
			<a:font script="Ethi" typeface="Nyala"/>
			<a:font script="Beng" typeface="Vrinda"/>
			<a:font script="Gujr" typeface="Shruti"/>
			<a:font script="Khmr" typeface="DaunPenh"/>
			<a:font script="Knda" typeface="Tunga"/>
			<a:font script="Guru" typeface="Raavi"/>
			<a:font script="Cans" typeface="Euphemia"/>
			<a:font script="Cher" typeface="Plantagenet Cherokee"/>
			<a:font script="Yiii" typeface="Microsoft Yi Baiti"/>
			<a:font script="Tibt" typeface="Microsoft Himalaya"/>
			<a:font script="Thaa" typeface="MV Boli"/>
			<a:font script="Deva" typeface="Mangal"/>
			<a:font script="Telu" typeface="Gautami"/>
			<a:font script="Taml" typeface="Latha"/>
			<a:font script="Syrc" typeface="Estrangelo Edessa"/>
			<a:font script="Orya" typeface="Kalinga"/>
			<a:font script="Mlym" typeface="Kartika"/>
			<a:font script="Laoo" typeface="DokChampa"/>
			<a:font script="Sinh" typeface="Iskoola Pota"/>
			<a:font script="Mong" typeface="Mongolian Baiti"/>
			<a:font script="Viet" typeface="Arial"/>
			<a:font script="Uigh" typeface="Microsoft Uighur"/>
			<a:font script="Geor" typeface="Sylfaen"/>
		</a:minorFont>
	</a:fontScheme>
	<a:fmtScheme name="Office">
		<a:fillStyleLst>
			<a:solidFill>
				<a:schemeClr val="phClr"/>
			</a:solidFill>
			<a:gradFill rotWithShape="1">
				<a:gsLst>
					<a:gs pos="0">
						<a:schemeClr val="phClr">
							<a:lumMod val="110000"/>
							<a:satMod val="105000"/>
							<a:tint val="67000"/>
						</a:schemeClr>
					</a:gs>
					<a:gs pos="50000">
						<a:schemeClr val="phClr">
							<a:lumMod val="105000"/>
							<a:satMod val="103000"/>
							<a:tint val="73000"/>
						</a:schemeClr>
					</a:gs>
					<a:gs pos="100000">
						<a:schemeClr val="phClr">
							<a:lumMod val="105000"/>
							<a:satMod val="109000"/>
							<a:tint val="81000"/>
						</a:schemeClr>
					</a:gs>
				</a:gsLst>
				<a:lin ang="5400000" scaled="0"/>
			</a:gradFill>
			<a:gradFill rotWithShape="1">
				<a:gsLst>
					<a:gs pos="0">
						<a:schemeClr val="phClr">
							<a:satMod val="103000"/>
							<a:lumMod val="102000"/>
							<a:tint val="94000"/>
						</a:schemeClr>
					</a:gs>
					<a:gs pos="50000">
						<a:schemeClr val="phClr">
							<a:satMod val="110000"/>
							<a:lumMod val="100000"/>
							<a:shade val="100000"/>
						</a:schemeClr>
					</a:gs>
					<a:gs pos="100000">
						<a:schemeClr val="phClr">
							<a:lumMod val="99000"/>
							<a:satMod val="120000"/>
							<a:shade val="78000"/>
						</a:schemeClr>
					</a:gs>
				</a:gsLst>
				<a:lin ang="5400000" scaled="0"/>
			</a:gradFill>
		</a:fillStyleLst>
		<a:lnStyleLst>
			<a:ln w="6350" cap="flat" cmpd="sng" algn="ctr">
				<a:solidFill>
					<a:schemeClr val="phClr"/>
				</a:solidFill>
				<a:prstDash val="solid"/>
				<a:miter lim="800000"/>
			</a:ln>
			<a:ln w="12700" cap="flat" cmpd="sng" algn="ctr">
				<a:solidFill>
					<a:schemeClr val="phClr"/>
				</a:solidFill>
				<a:prstDash val="solid"/>
				<a:miter lim="800000"/>
			</a:ln>
			<a:ln w="19050" cap="flat" cmpd="sng" algn="ctr">
				<a:solidFill>
					<a:schemeClr val="phClr"/>
				</a:solidFill>
				<a:prstDash val="solid"/>
				<a:miter lim="800000"/>
			</a:ln>
		</a:lnStyleLst>
		<a:effectStyleLst>
			<a:effectStyle>
				<a:effectLst/>
			</a:effectStyle>
			<a:effectStyle>
				<a:effectLst/>
			</a:effectStyle>
			<a:effectStyle>
				<a:effectLst>
					<a:outerShdw blurRad="57150" dist="19050" dir="5400000" algn="ctr" rotWithShape="0">
						<a:srgbClr val="000000">
							<a:alpha val="63000"/>
						</a:srgbClr>
					</a:outerShdw>
				</a:effectLst>
			</a:effectStyle>
		</a:effectStyleLst>
		<a:bgFillStyleLst>
			<a:solidFill>
				<a:schemeClr val="phClr"/>
			</a:solidFill>
			<a:solidFill>
				<a:schemeClr val="phClr">
					<a:tint val="95000"/>
					<a:satMod val="170000"/>
				</a:schemeClr>
			</a:solidFill>
			<a:gradFill rotWithShape="1">
				<a:gsLst>
					<a:gs pos="0">
						<a:schemeClr val="phClr">
							<a:tint val="93000"/>
							<a:satMod val="150000"/>
							<a:shade val="98000"/>
							<a:lumMod val="102000"/>
						</a:schemeClr>
					</a:gs>
					<a:gs pos="50000">
						<a:schemeClr val="phClr">
							<a:tint val="98000"/>
							<a:satMod val="130000"/>
							<a:shade val="90000"/>
							<a:lumMod val="103000"/>
						</a:schemeClr>
					</a:gs>
					<a:gs pos="100000">
						<a:schemeClr val="phClr">
							<a:shade val="63000"/>
							<a:satMod val="120000"/>
						</a:schemeClr>
					</a:gs>
				</a:gsLst>
				<a:lin ang="5400000" scaled="0"/>
			</a:gradFill>
		</a:bgFillStyleLst>
	</a:fmtScheme>
</a:themeElements>
<a:objectDefaults/>
<a:extraClrSchemeLst/>
<a:extLst>
	<a:ext uri="{05A4C25C-085E-4340-85A3-A5531E510DB2}">
		<thm15:themeFamily name="Office Theme" id="{62F939B6-93AF-4DB8-9C6B-D6C7DFDC589F}" vid="{4A3C46E8-61CC-4603-A589-7422A47A8E4A}" xmlns:thm15="http://schemas.microsoft.com/office/thememl/2012/main"/>
	</a:ext>
</a:extLst>
</a:theme>
</pkg:xmlData>
</pkg:part>
<pkg:part pkg:name="/word/settings.xml" pkg:contentType="application/vnd.openxmlformats-officedocument.wordprocessingml.settings+xml">
	<pkg:xmlData>
		<w:settings mc:Ignorable="w14 w15" xmlns:mc="http://schemas.openxmlformats.org/markup-compatibility/2006" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:r="http://schemas.openxmlformats.org/officeDocument/2006/relationships" xmlns:m="http://schemas.openxmlformats.org/officeDocument/2006/math" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w10="urn:schemas-microsoft-com:office:word" xmlns:w="http://schemas.openxmlformats.org/wordprocessingml/2006/main" xmlns:w14="http://schemas.microsoft.com/office/word/2010/wordml" xmlns:w15="http://schemas.microsoft.com/office/word/2012/wordml" xmlns:sl="http://schemas.openxmlformats.org/schemaLibrary/2006/main">
			<w:zoom w:percent="180"/>
			<w:bordersDoNotSurroundHeader/>
			<w:bordersDoNotSurroundFooter/>
			<w:proofState w:spelling="clean" w:grammar="clean"/>
			<w:defaultTabStop w:val="420"/>
			<w:drawingGridVerticalSpacing w:val="156"/>
			<w:displayHorizontalDrawingGridEvery w:val="0"/>
			<w:displayVerticalDrawingGridEvery w:val="2"/>
			<w:characterSpacingControl w:val="compressPunctuation"/>
			<w:compat>
				<w:spaceForUL/>
				<w:balanceSingleByteDoubleByteWidth/>
				<w:doNotLeaveBackslashAlone/>
				<w:ulTrailSpace/>
				<w:doNotExpandShiftReturn/>
				<w:adjustLineHeightInTable/>
				<w:useFELayout/>
				<w:compatSetting w:name="compatibilityMode" w:uri="http://schemas.microsoft.com/office/word" w:val="14"/>
				<w:compatSetting w:name="overrideTableStyleFontSizeAndJustification" w:uri="http://schemas.microsoft.com/office/word" w:val="1"/>
				<w:compatSetting w:name="enableOpenTypeFeatures" w:uri="http://schemas.microsoft.com/office/word" w:val="1"/>
				<w:compatSetting w:name="doNotFlipMirrorIndents" w:uri="http://schemas.microsoft.com/office/word" w:val="1"/>
			</w:compat>
			<w:rsids>
				<w:rsidRoot w:val="00793991"/>
				<w:rsid w:val="00034FFF"/>
				<w:rsid w:val="00067A27"/>
				<w:rsid w:val="0036437E"/>
				<w:rsid w:val="004E3488"/>
				<w:rsid w:val="00793991"/>
				<w:rsid w:val="0082354D"/>
				<w:rsid w:val="008C131C"/>
				<w:rsid w:val="008E0477"/>
				<w:rsid w:val="00975F06"/>
				<w:rsid w:val="00A6130A"/>
				<w:rsid w:val="00B82279"/>
				<w:rsid w:val="00BF692D"/>
				<w:rsid w:val="00CB703B"/>
				<w:rsid w:val="00D911A4"/>
				<w:rsid w:val="00E03A51"/>
			</w:rsids>
			<m:mathPr>
				<m:mathFont m:val="Cambria Math"/>
				<m:brkBin m:val="before"/>
				<m:brkBinSub m:val="--"/>
				<m:smallFrac m:val="0"/>
				<m:dispDef/>
				<m:lMargin m:val="0"/>
				<m:rMargin m:val="0"/>
				<m:defJc m:val="centerGroup"/>
				<m:wrapIndent m:val="1440"/>
				<m:intLim m:val="subSup"/>
				<m:naryLim m:val="undOvr"/>
			</m:mathPr>
			<w:themeFontLang w:val="en-US" w:eastAsia="zh-CN"/>
			<w:clrSchemeMapping w:bg1="light1" w:t1="dark1" w:bg2="light2" w:t2="dark2" w:accent1="accent1" w:accent2="accent2" w:accent3="accent3" w:accent4="accent4" w:accent5="accent5" w:accent6="accent6" w:hyperlink="hyperlink" w:followedHyperlink="followedHyperlink"/>
			<w:shapeDefaults>
				<o:shapedefaults v:ext="edit" spidmax="1026"/>
				<o:shapelayout v:ext="edit">
					<o:idmap v:ext="edit" data="1"/>
				</o:shapelayout>
			</w:shapeDefaults>
			<w:decimalSymbol w:val="."/>
			<w:listSeparator w:val=","/>
			<w15:docId w15:val="{7CD05330-8C42-4654-91A1-6294297987AF}"/>
		</w:settings>
	</pkg:xmlData>
</pkg:part>
<pkg:part pkg:name="/word/fontTable.xml" pkg:contentType="application/vnd.openxmlformats-officedocument.wordprocessingml.fontTable+xml">
	<pkg:xmlData>
		<w:fonts mc:Ignorable="w14 w15" xmlns:mc="http://schemas.openxmlformats.org/markup-compatibility/2006" xmlns:r="http://schemas.openxmlformats.org/officeDocument/2006/relationships" xmlns:w="http://schemas.openxmlformats.org/wordprocessingml/2006/main" xmlns:w14="http://schemas.microsoft.com/office/word/2010/wordml" xmlns:w15="http://schemas.microsoft.com/office/word/2012/wordml">
			<w:font w:name="Calibri">
				<w:panose1 w:val="020F0502020204030204"/>
				<w:charset w:val="00"/>
				<w:family w:val="swiss"/>
				<w:pitch w:val="variable"/>
				<w:sig w:usb0="E10002FF" w:usb1="4000ACFF" w:usb2="00000009" w:usb3="00000000" w:csb0="0000019F" w:csb1="00000000"/>
			</w:font>
			<w:font w:name="宋体"><w:altName w:val="SimSun"/>
			<w:panose1 w:val="02010600030101010101"/>
			<w:charset w:val="86"/>
			<w:family w:val="auto"/>
			<w:pitch w:val="variable"/>
			<w:sig w:usb0="00000003" w:usb1="288F0000" w:usb2="00000016" w:usb3="00000000" w:csb0="00040001" w:csb1="00000000"/>
		</w:font>
		<w:font w:name="Times New Roman">
			<w:panose1 w:val="02020603050405020304"/>
			<w:charset w:val="00"/>
			<w:family w:val="roman"/>
			<w:pitch w:val="variable"/>
			<w:sig w:usb0="E0002AFF" w:usb1="C0007841" w:usb2="00000009" w:usb3="00000000" w:csb0="000001FF" w:csb1="00000000"/>
		</w:font>
		<w:font w:name="Calibri Light">
			<w:panose1 w:val="020F0302020204030204"/>
			<w:charset w:val="00"/>
			<w:family w:val="swiss"/>
			<w:pitch w:val="variable"/>
			<w:sig w:usb0="A00002EF" w:usb1="4000207B" w:usb2="00000000" w:usb3="00000000" w:csb0="0000019F" w:csb1="00000000"/>
		</w:font>
	</w:fonts>
</pkg:xmlData>
</pkg:part>
<pkg:part pkg:name="/word/webSettings.xml" pkg:contentType="application/vnd.openxmlformats-officedocument.wordprocessingml.webSettings+xml">
	<pkg:xmlData>
		<w:webSettings mc:Ignorable="w14 w15" xmlns:mc="http://schemas.openxmlformats.org/markup-compatibility/2006" xmlns:r="http://schemas.openxmlformats.org/officeDocument/2006/relationships" xmlns:w="http://schemas.openxmlformats.org/wordprocessingml/2006/main" xmlns:w14="http://schemas.microsoft.com/office/word/2010/wordml" xmlns:w15="http://schemas.microsoft.com/office/word/2012/wordml">
			<w:divs>
				<w:div w:id="912668619">
					<w:bodyDiv w:val="1"/>
					<w:marLeft w:val="0"/>
					<w:marRight w:val="0"/>
					<w:marTop w:val="0"/>
					<w:marBottom w:val="0"/>
					<w:divBdr>
						<w:top w:val="none" w:sz="0" w:space="0" w:color="auto"/>
						<w:left w:val="none" w:sz="0" w:space="0" w:color="auto"/>
						<w:bottom w:val="none" w:sz="0" w:space="0" w:color="auto"/>
						<w:right w:val="none" w:sz="0" w:space="0" w:color="auto"/>
					</w:divBdr>
				</w:div>
			</w:divs>
			<w:optimizeForBrowser/>
			<w:allowPNG/>
		</w:webSettings>
	</pkg:xmlData>
</pkg:part>
<pkg:part pkg:name="/docProps/app.xml" pkg:contentType="application/vnd.openxmlformats-officedocument.extended-properties+xml" pkg:padding="256">
	<pkg:xmlData>
		<Properties xmlns="http://schemas.openxmlformats.org/officeDocument/2006/extended-properties" xmlns:vt="http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes">
			<Template>Normal.dotm</Template>
			<TotalTime>1</TotalTime>
			<Pages>1</Pages>
			<Words>0</Words>
			<Characters>5</Characters>
			<Application>Microsoft Office Word</Application>
			<DocSecurity>0</DocSecurity>
			<Lines>1</Lines>
			<Paragraphs>1</Paragraphs>
			<ScaleCrop>false</ScaleCrop>
			<Company>Hewlett-Packard Company</Company>
			<LinksUpToDate>false</LinksUpToDate>
			<CharactersWithSpaces>5</CharactersWithSpaces>
			<SharedDoc>false</SharedDoc>
			<HyperlinksChanged>false</HyperlinksChanged>
			<AppVersion>15.0000</AppVersion>
		</Properties>
	</pkg:xmlData>
</pkg:part>
<pkg:part pkg:name="/docProps/core.xml" pkg:contentType="application/vnd.openxmlformats-package.core-properties+xml" pkg:padding="256">
	<pkg:xmlData>
		<cp:coreProperties xmlns:cp="http://schemas.openxmlformats.org/package/2006/metadata/core-properties" xmlns:dc="http://purl.org/dc/elements/1.1/" xmlns:dcterms="http://purl.org/dc/terms/" xmlns:dcmitype="http://purl.org/dc/dcmitype/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
			<dc:title/>
			<dc:subject/>
			<dc:creator>sophie</dc:creator>
			<cp:keywords/>
			<dc:description/>
			<cp:lastModifiedBy>sophie</cp:lastModifiedBy>
			<cp:revision>3</cp:revision>
			<dcterms:created xsi:type="dcterms:W3CDTF">2018-12-27T02:57:00Z</dcterms:created>
			<dcterms:modified xsi:type="dcterms:W3CDTF">2018-12-27T03:56:00Z</dcterms:modified>
		</cp:coreProperties>
	</pkg:xmlData>
</pkg:part>
<pkg:part pkg:name="/word/styles.xml" pkg:contentType="application/vnd.openxmlformats-officedocument.wordprocessingml.styles+xml">
	<pkg:xmlData>
		<w:styles mc:Ignorable="w14 w15" xmlns:mc="http://schemas.openxmlformats.org/markup-compatibility/2006" xmlns:r="http://schemas.openxmlformats.org/officeDocument/2006/relationships" xmlns:w="http://schemas.openxmlformats.org/wordprocessingml/2006/main" xmlns:w14="http://schemas.microsoft.com/office/word/2010/wordml" xmlns:w15="http://schemas.microsoft.com/office/word/2012/wordml">
			<w:docDefaults>
				<w:rPrDefault>
					<w:rPr>
						<w:rFonts w:asciiTheme="minorHAnsi" w:eastAsiaTheme="minorEastAsia" w:hAnsiTheme="minorHAnsi" w:cstheme="minorBidi"/>
						<w:kern w:val="2"/>
						<w:sz w:val="21"/>
						<w:szCs w:val="22"/>
						<w:lang w:val="en-US" w:eastAsia="zh-CN" w:bidi="ar-SA"/>
					</w:rPr>
				</w:rPrDefault>
				<w:pPrDefault/>
			</w:docDefaults>
			<w:latentStyles w:defLockedState="0" w:defUIPriority="99" w:defSemiHidden="0" w:defUnhideWhenUsed="0" w:defQFormat="0" w:count="371">
				<w:lsdException w:name="Normal" w:uiPriority="0" w:qFormat="1"/>
				<w:lsdException w:name="heading 1" w:uiPriority="9" w:qFormat="1"/>
				<w:lsdException w:name="heading 2" w:semiHidden="1" w:uiPriority="9" w:unhideWhenUsed="1" w:qFormat="1"/>
				<w:lsdException w:name="heading 3" w:semiHidden="1" w:uiPriority="9" w:unhideWhenUsed="1" w:qFormat="1"/>
				<w:lsdException w:name="heading 4" w:semiHidden="1" w:uiPriority="9" w:unhideWhenUsed="1" w:qFormat="1"/>
				<w:lsdException w:name="heading 5" w:semiHidden="1" w:uiPriority="9" w:unhideWhenUsed="1" w:qFormat="1"/>
				<w:lsdException w:name="heading 6" w:semiHidden="1" w:uiPriority="9" w:unhideWhenUsed="1" w:qFormat="1"/>
				<w:lsdException w:name="heading 7" w:semiHidden="1" w:uiPriority="9" w:unhideWhenUsed="1" w:qFormat="1"/>
				<w:lsdException w:name="heading 8" w:semiHidden="1" w:uiPriority="9" w:unhideWhenUsed="1" w:qFormat="1"/>
				<w:lsdException w:name="heading 9" w:semiHidden="1" w:uiPriority="9" w:unhideWhenUsed="1" w:qFormat="1"/>
				<w:lsdException w:name="index 1" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="index 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="index 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="index 4" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="index 5" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="index 6" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="index 7" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="index 8" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="index 9" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="toc 1" w:semiHidden="1" w:uiPriority="39" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="toc 2" w:semiHidden="1" w:uiPriority="39" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="toc 3" w:semiHidden="1" w:uiPriority="39" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="toc 4" w:semiHidden="1" w:uiPriority="39" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="toc 5" w:semiHidden="1" w:uiPriority="39" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="toc 6" w:semiHidden="1" w:uiPriority="39" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="toc 7" w:semiHidden="1" w:uiPriority="39" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="toc 8" w:semiHidden="1" w:uiPriority="39" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="toc 9" w:semiHidden="1" w:uiPriority="39" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Normal Indent" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="footnote text" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="annotation text" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="header" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="footer" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="index heading" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="caption" w:semiHidden="1" w:uiPriority="35" w:unhideWhenUsed="1" w:qFormat="1"/>
				<w:lsdException w:name="table of figures" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="envelope address" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="envelope return" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="footnote reference" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="annotation reference" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="line number" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="page number" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="endnote reference" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="endnote text" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="table of authorities" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="macro" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="toa heading" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Bullet" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Number" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List 4" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List 5" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Bullet 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Bullet 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Bullet 4" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Bullet 5" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Number 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Number 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Number 4" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Number 5" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Title" w:uiPriority="10" w:qFormat="1"/>
				<w:lsdException w:name="Closing" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Signature" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Default Paragraph Font" w:semiHidden="1" w:uiPriority="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Body Text" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Body Text Indent" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Continue" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Continue 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Continue 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Continue 4" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="List Continue 5" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Message Header" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Subtitle" w:uiPriority="11" w:qFormat="1"/>
				<w:lsdException w:name="Salutation" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Date" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Body Text First Indent" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Body Text First Indent 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Note Heading" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Body Text 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Body Text 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Body Text Indent 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Body Text Indent 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Block Text" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Hyperlink" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="FollowedHyperlink" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Strong" w:uiPriority="22" w:qFormat="1"/>
				<w:lsdException w:name="Emphasis" w:uiPriority="20" w:qFormat="1"/>
				<w:lsdException w:name="Document Map" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Plain Text" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="E-mail Signature" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="HTML Top of Form" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="HTML Bottom of Form" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Normal (Web)" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="HTML Acronym" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="HTML Address" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="HTML Cite" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="HTML Code" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="HTML Definition" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="HTML Keyboard" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="HTML Preformatted" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="HTML Sample" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="HTML Typewriter" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="HTML Variable" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Normal Table" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="annotation subject" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="No List" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Outline List 1" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Outline List 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Outline List 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Simple 1" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Simple 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Simple 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Classic 1" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Classic 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Classic 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Classic 4" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Colorful 1" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Colorful 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Colorful 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Columns 1" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Columns 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Columns 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Columns 4" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Columns 5" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Grid 1" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Grid 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Grid 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Grid 4" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Grid 5" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Grid 6" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Grid 7" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Grid 8" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table List 1" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table List 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table List 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table List 4" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table List 5" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table List 6" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table List 7" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table List 8" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table 3D effects 1" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table 3D effects 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table 3D effects 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Contemporary" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Elegant" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Professional" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Subtle 1" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Subtle 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Web 1" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Web 2" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Web 3" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Balloon Text" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Table Grid" w:uiPriority="39"/>
				<w:lsdException w:name="Table Theme" w:semiHidden="1" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="Placeholder Text" w:semiHidden="1"/>
				<w:lsdException w:name="No Spacing" w:uiPriority="1" w:qFormat="1"/>
				<w:lsdException w:name="Light Shading" w:uiPriority="60"/>
				<w:lsdException w:name="Light List" w:uiPriority="61"/>
				<w:lsdException w:name="Light Grid" w:uiPriority="62"/>
				<w:lsdException w:name="Medium Shading 1" w:uiPriority="63"/>
				<w:lsdException w:name="Medium Shading 2" w:uiPriority="64"/>
				<w:lsdException w:name="Medium List 1" w:uiPriority="65"/>
				<w:lsdException w:name="Medium List 2" w:uiPriority="66"/>
				<w:lsdException w:name="Medium Grid 1" w:uiPriority="67"/>
				<w:lsdException w:name="Medium Grid 2" w:uiPriority="68"/>
				<w:lsdException w:name="Medium Grid 3" w:uiPriority="69"/>
				<w:lsdException w:name="Dark List" w:uiPriority="70"/>
				<w:lsdException w:name="Colorful Shading" w:uiPriority="71"/>
				<w:lsdException w:name="Colorful List" w:uiPriority="72"/>
				<w:lsdException w:name="Colorful Grid" w:uiPriority="73"/>
				<w:lsdException w:name="Light Shading Accent 1" w:uiPriority="60"/>
				<w:lsdException w:name="Light List Accent 1" w:uiPriority="61"/>
				<w:lsdException w:name="Light Grid Accent 1" w:uiPriority="62"/>
				<w:lsdException w:name="Medium Shading 1 Accent 1" w:uiPriority="63"/>
				<w:lsdException w:name="Medium Shading 2 Accent 1" w:uiPriority="64"/>
				<w:lsdException w:name="Medium List 1 Accent 1" w:uiPriority="65"/>
				<w:lsdException w:name="Revision" w:semiHidden="1"/>
				<w:lsdException w:name="List Paragraph" w:uiPriority="34" w:qFormat="1"/>
				<w:lsdException w:name="Quote" w:uiPriority="29" w:qFormat="1"/>
				<w:lsdException w:name="Intense Quote" w:uiPriority="30" w:qFormat="1"/>
				<w:lsdException w:name="Medium List 2 Accent 1" w:uiPriority="66"/>
				<w:lsdException w:name="Medium Grid 1 Accent 1" w:uiPriority="67"/>
				<w:lsdException w:name="Medium Grid 2 Accent 1" w:uiPriority="68"/>
				<w:lsdException w:name="Medium Grid 3 Accent 1" w:uiPriority="69"/>
				<w:lsdException w:name="Dark List Accent 1" w:uiPriority="70"/>
				<w:lsdException w:name="Colorful Shading Accent 1" w:uiPriority="71"/>
				<w:lsdException w:name="Colorful List Accent 1" w:uiPriority="72"/>
				<w:lsdException w:name="Colorful Grid Accent 1" w:uiPriority="73"/>
				<w:lsdException w:name="Light Shading Accent 2" w:uiPriority="60"/>
				<w:lsdException w:name="Light List Accent 2" w:uiPriority="61"/>
				<w:lsdException w:name="Light Grid Accent 2" w:uiPriority="62"/>
				<w:lsdException w:name="Medium Shading 1 Accent 2" w:uiPriority="63"/>
				<w:lsdException w:name="Medium Shading 2 Accent 2" w:uiPriority="64"/>
				<w:lsdException w:name="Medium List 1 Accent 2" w:uiPriority="65"/>
				<w:lsdException w:name="Medium List 2 Accent 2" w:uiPriority="66"/>
				<w:lsdException w:name="Medium Grid 1 Accent 2" w:uiPriority="67"/>
				<w:lsdException w:name="Medium Grid 2 Accent 2" w:uiPriority="68"/>
				<w:lsdException w:name="Medium Grid 3 Accent 2" w:uiPriority="69"/>
				<w:lsdException w:name="Dark List Accent 2" w:uiPriority="70"/>
				<w:lsdException w:name="Colorful Shading Accent 2" w:uiPriority="71"/>
				<w:lsdException w:name="Colorful List Accent 2" w:uiPriority="72"/>
				<w:lsdException w:name="Colorful Grid Accent 2" w:uiPriority="73"/>
				<w:lsdException w:name="Light Shading Accent 3" w:uiPriority="60"/>
				<w:lsdException w:name="Light List Accent 3" w:uiPriority="61"/>
				<w:lsdException w:name="Light Grid Accent 3" w:uiPriority="62"/>
				<w:lsdException w:name="Medium Shading 1 Accent 3" w:uiPriority="63"/>
				<w:lsdException w:name="Medium Shading 2 Accent 3" w:uiPriority="64"/>
				<w:lsdException w:name="Medium List 1 Accent 3" w:uiPriority="65"/>
				<w:lsdException w:name="Medium List 2 Accent 3" w:uiPriority="66"/>
				<w:lsdException w:name="Medium Grid 1 Accent 3" w:uiPriority="67"/>
				<w:lsdException w:name="Medium Grid 2 Accent 3" w:uiPriority="68"/>
				<w:lsdException w:name="Medium Grid 3 Accent 3" w:uiPriority="69"/>
				<w:lsdException w:name="Dark List Accent 3" w:uiPriority="70"/>
				<w:lsdException w:name="Colorful Shading Accent 3" w:uiPriority="71"/>
				<w:lsdException w:name="Colorful List Accent 3" w:uiPriority="72"/>
				<w:lsdException w:name="Colorful Grid Accent 3" w:uiPriority="73"/>
				<w:lsdException w:name="Light Shading Accent 4" w:uiPriority="60"/>
				<w:lsdException w:name="Light List Accent 4" w:uiPriority="61"/>
				<w:lsdException w:name="Light Grid Accent 4" w:uiPriority="62"/>
				<w:lsdException w:name="Medium Shading 1 Accent 4" w:uiPriority="63"/>
				<w:lsdException w:name="Medium Shading 2 Accent 4" w:uiPriority="64"/>
				<w:lsdException w:name="Medium List 1 Accent 4" w:uiPriority="65"/>
				<w:lsdException w:name="Medium List 2 Accent 4" w:uiPriority="66"/>
				<w:lsdException w:name="Medium Grid 1 Accent 4" w:uiPriority="67"/>
				<w:lsdException w:name="Medium Grid 2 Accent 4" w:uiPriority="68"/>
				<w:lsdException w:name="Medium Grid 3 Accent 4" w:uiPriority="69"/>
				<w:lsdException w:name="Dark List Accent 4" w:uiPriority="70"/>
				<w:lsdException w:name="Colorful Shading Accent 4" w:uiPriority="71"/>
				<w:lsdException w:name="Colorful List Accent 4" w:uiPriority="72"/>
				<w:lsdException w:name="Colorful Grid Accent 4" w:uiPriority="73"/>
				<w:lsdException w:name="Light Shading Accent 5" w:uiPriority="60"/>
				<w:lsdException w:name="Light List Accent 5" w:uiPriority="61"/>
				<w:lsdException w:name="Light Grid Accent 5" w:uiPriority="62"/>
				<w:lsdException w:name="Medium Shading 1 Accent 5" w:uiPriority="63"/>
				<w:lsdException w:name="Medium Shading 2 Accent 5" w:uiPriority="64"/>
				<w:lsdException w:name="Medium List 1 Accent 5" w:uiPriority="65"/>
				<w:lsdException w:name="Medium List 2 Accent 5" w:uiPriority="66"/>
				<w:lsdException w:name="Medium Grid 1 Accent 5" w:uiPriority="67"/>
				<w:lsdException w:name="Medium Grid 2 Accent 5" w:uiPriority="68"/>
				<w:lsdException w:name="Medium Grid 3 Accent 5" w:uiPriority="69"/>
				<w:lsdException w:name="Dark List Accent 5" w:uiPriority="70"/>
				<w:lsdException w:name="Colorful Shading Accent 5" w:uiPriority="71"/>
				<w:lsdException w:name="Colorful List Accent 5" w:uiPriority="72"/>
				<w:lsdException w:name="Colorful Grid Accent 5" w:uiPriority="73"/>
				<w:lsdException w:name="Light Shading Accent 6" w:uiPriority="60"/>
				<w:lsdException w:name="Light List Accent 6" w:uiPriority="61"/>
				<w:lsdException w:name="Light Grid Accent 6" w:uiPriority="62"/>
				<w:lsdException w:name="Medium Shading 1 Accent 6" w:uiPriority="63"/>
				<w:lsdException w:name="Medium Shading 2 Accent 6" w:uiPriority="64"/>
				<w:lsdException w:name="Medium List 1 Accent 6" w:uiPriority="65"/>
				<w:lsdException w:name="Medium List 2 Accent 6" w:uiPriority="66"/>
				<w:lsdException w:name="Medium Grid 1 Accent 6" w:uiPriority="67"/>
				<w:lsdException w:name="Medium Grid 2 Accent 6" w:uiPriority="68"/>
				<w:lsdException w:name="Medium Grid 3 Accent 6" w:uiPriority="69"/>
				<w:lsdException w:name="Dark List Accent 6" w:uiPriority="70"/>
				<w:lsdException w:name="Colorful Shading Accent 6" w:uiPriority="71"/>
				<w:lsdException w:name="Colorful List Accent 6" w:uiPriority="72"/>
				<w:lsdException w:name="Colorful Grid Accent 6" w:uiPriority="73"/>
				<w:lsdException w:name="Subtle Emphasis" w:uiPriority="19" w:qFormat="1"/>
				<w:lsdException w:name="Intense Emphasis" w:uiPriority="21" w:qFormat="1"/>
				<w:lsdException w:name="Subtle Reference" w:uiPriority="31" w:qFormat="1"/>
				<w:lsdException w:name="Intense Reference" w:uiPriority="32" w:qFormat="1"/>
				<w:lsdException w:name="Book Title" w:uiPriority="33" w:qFormat="1"/>
				<w:lsdException w:name="Bibliography" w:semiHidden="1" w:uiPriority="37" w:unhideWhenUsed="1"/>
				<w:lsdException w:name="TOC Heading" w:semiHidden="1" w:uiPriority="39" w:unhideWhenUsed="1" w:qFormat="1"/>
				<w:lsdException w:name="Plain Table 1" w:uiPriority="41"/>
				<w:lsdException w:name="Plain Table 2" w:uiPriority="42"/>
				<w:lsdException w:name="Plain Table 3" w:uiPriority="43"/>
				<w:lsdException w:name="Plain Table 4" w:uiPriority="44"/>
				<w:lsdException w:name="Plain Table 5" w:uiPriority="45"/>
				<w:lsdException w:name="Grid Table Light" w:uiPriority="40"/>
				<w:lsdException w:name="Grid Table 1 Light" w:uiPriority="46"/>
				<w:lsdException w:name="Grid Table 2" w:uiPriority="47"/>
				<w:lsdException w:name="Grid Table 3" w:uiPriority="48"/>
				<w:lsdException w:name="Grid Table 4" w:uiPriority="49"/>
				<w:lsdException w:name="Grid Table 5 Dark" w:uiPriority="50"/>
				<w:lsdException w:name="Grid Table 6 Colorful" w:uiPriority="51"/>
				<w:lsdException w:name="Grid Table 7 Colorful" w:uiPriority="52"/>
				<w:lsdException w:name="Grid Table 1 Light Accent 1" w:uiPriority="46"/>
				<w:lsdException w:name="Grid Table 2 Accent 1" w:uiPriority="47"/>
				<w:lsdException w:name="Grid Table 3 Accent 1" w:uiPriority="48"/>
				<w:lsdException w:name="Grid Table 4 Accent 1" w:uiPriority="49"/>
				<w:lsdException w:name="Grid Table 5 Dark Accent 1" w:uiPriority="50"/>
				<w:lsdException w:name="Grid Table 6 Colorful Accent 1" w:uiPriority="51"/>
				<w:lsdException w:name="Grid Table 7 Colorful Accent 1" w:uiPriority="52"/>
				<w:lsdException w:name="Grid Table 1 Light Accent 2" w:uiPriority="46"/>
				<w:lsdException w:name="Grid Table 2 Accent 2" w:uiPriority="47"/>
				<w:lsdException w:name="Grid Table 3 Accent 2" w:uiPriority="48"/>
				<w:lsdException w:name="Grid Table 4 Accent 2" w:uiPriority="49"/>
				<w:lsdException w:name="Grid Table 5 Dark Accent 2" w:uiPriority="50"/>
				<w:lsdException w:name="Grid Table 6 Colorful Accent 2" w:uiPriority="51"/>
				<w:lsdException w:name="Grid Table 7 Colorful Accent 2" w:uiPriority="52"/>
				<w:lsdException w:name="Grid Table 1 Light Accent 3" w:uiPriority="46"/>
				<w:lsdException w:name="Grid Table 2 Accent 3" w:uiPriority="47"/>
				<w:lsdException w:name="Grid Table 3 Accent 3" w:uiPriority="48"/>
				<w:lsdException w:name="Grid Table 4 Accent 3" w:uiPriority="49"/>
				<w:lsdException w:name="Grid Table 5 Dark Accent 3" w:uiPriority="50"/>
				<w:lsdException w:name="Grid Table 6 Colorful Accent 3" w:uiPriority="51"/>
				<w:lsdException w:name="Grid Table 7 Colorful Accent 3" w:uiPriority="52"/>
				<w:lsdException w:name="Grid Table 1 Light Accent 4" w:uiPriority="46"/>
				<w:lsdException w:name="Grid Table 2 Accent 4" w:uiPriority="47"/>
				<w:lsdException w:name="Grid Table 3 Accent 4" w:uiPriority="48"/>
				<w:lsdException w:name="Grid Table 4 Accent 4" w:uiPriority="49"/>
				<w:lsdException w:name="Grid Table 5 Dark Accent 4" w:uiPriority="50"/>
				<w:lsdException w:name="Grid Table 6 Colorful Accent 4" w:uiPriority="51"/>
				<w:lsdException w:name="Grid Table 7 Colorful Accent 4" w:uiPriority="52"/>
				<w:lsdException w:name="Grid Table 1 Light Accent 5" w:uiPriority="46"/>
				<w:lsdException w:name="Grid Table 2 Accent 5" w:uiPriority="47"/>
				<w:lsdException w:name="Grid Table 3 Accent 5" w:uiPriority="48"/>
				<w:lsdException w:name="Grid Table 4 Accent 5" w:uiPriority="49"/>
				<w:lsdException w:name="Grid Table 5 Dark Accent 5" w:uiPriority="50"/>
				<w:lsdException w:name="Grid Table 6 Colorful Accent 5" w:uiPriority="51"/>
				<w:lsdException w:name="Grid Table 7 Colorful Accent 5" w:uiPriority="52"/>
				<w:lsdException w:name="Grid Table 1 Light Accent 6" w:uiPriority="46"/>
				<w:lsdException w:name="Grid Table 2 Accent 6" w:uiPriority="47"/>
				<w:lsdException w:name="Grid Table 3 Accent 6" w:uiPriority="48"/>
				<w:lsdException w:name="Grid Table 4 Accent 6" w:uiPriority="49"/>
				<w:lsdException w:name="Grid Table 5 Dark Accent 6" w:uiPriority="50"/>
				<w:lsdException w:name="Grid Table 6 Colorful Accent 6" w:uiPriority="51"/>
				<w:lsdException w:name="Grid Table 7 Colorful Accent 6" w:uiPriority="52"/>
				<w:lsdException w:name="List Table 1 Light" w:uiPriority="46"/>
				<w:lsdException w:name="List Table 2" w:uiPriority="47"/>
				<w:lsdException w:name="List Table 3" w:uiPriority="48"/>
				<w:lsdException w:name="List Table 4" w:uiPriority="49"/>
				<w:lsdException w:name="List Table 5 Dark" w:uiPriority="50"/>
				<w:lsdException w:name="List Table 6 Colorful" w:uiPriority="51"/>
				<w:lsdException w:name="List Table 7 Colorful" w:uiPriority="52"/>
				<w:lsdException w:name="List Table 1 Light Accent 1" w:uiPriority="46"/>
				<w:lsdException w:name="List Table 2 Accent 1" w:uiPriority="47"/>
				<w:lsdException w:name="List Table 3 Accent 1" w:uiPriority="48"/>
				<w:lsdException w:name="List Table 4 Accent 1" w:uiPriority="49"/>
				<w:lsdException w:name="List Table 5 Dark Accent 1" w:uiPriority="50"/>
				<w:lsdException w:name="List Table 6 Colorful Accent 1" w:uiPriority="51"/>
				<w:lsdException w:name="List Table 7 Colorful Accent 1" w:uiPriority="52"/>
				<w:lsdException w:name="List Table 1 Light Accent 2" w:uiPriority="46"/>
				<w:lsdException w:name="List Table 2 Accent 2" w:uiPriority="47"/>
				<w:lsdException w:name="List Table 3 Accent 2" w:uiPriority="48"/>
				<w:lsdException w:name="List Table 4 Accent 2" w:uiPriority="49"/>
				<w:lsdException w:name="List Table 5 Dark Accent 2" w:uiPriority="50"/>
				<w:lsdException w:name="List Table 6 Colorful Accent 2" w:uiPriority="51"/>
				<w:lsdException w:name="List Table 7 Colorful Accent 2" w:uiPriority="52"/>
				<w:lsdException w:name="List Table 1 Light Accent 3" w:uiPriority="46"/>
				<w:lsdException w:name="List Table 2 Accent 3" w:uiPriority="47"/>
				<w:lsdException w:name="List Table 3 Accent 3" w:uiPriority="48"/>
				<w:lsdException w:name="List Table 4 Accent 3" w:uiPriority="49"/>
				<w:lsdException w:name="List Table 5 Dark Accent 3" w:uiPriority="50"/>
				<w:lsdException w:name="List Table 6 Colorful Accent 3" w:uiPriority="51"/>
				<w:lsdException w:name="List Table 7 Colorful Accent 3" w:uiPriority="52"/>
				<w:lsdException w:name="List Table 1 Light Accent 4" w:uiPriority="46"/>
				<w:lsdException w:name="List Table 2 Accent 4" w:uiPriority="47"/>
				<w:lsdException w:name="List Table 3 Accent 4" w:uiPriority="48"/>
				<w:lsdException w:name="List Table 4 Accent 4" w:uiPriority="49"/>
				<w:lsdException w:name="List Table 5 Dark Accent 4" w:uiPriority="50"/>
				<w:lsdException w:name="List Table 6 Colorful Accent 4" w:uiPriority="51"/>
				<w:lsdException w:name="List Table 7 Colorful Accent 4" w:uiPriority="52"/>
				<w:lsdException w:name="List Table 1 Light Accent 5" w:uiPriority="46"/>
				<w:lsdException w:name="List Table 2 Accent 5" w:uiPriority="47"/>
				<w:lsdException w:name="List Table 3 Accent 5" w:uiPriority="48"/>
				<w:lsdException w:name="List Table 4 Accent 5" w:uiPriority="49"/>
				<w:lsdException w:name="List Table 5 Dark Accent 5" w:uiPriority="50"/>
				<w:lsdException w:name="List Table 6 Colorful Accent 5" w:uiPriority="51"/>
				<w:lsdException w:name="List Table 7 Colorful Accent 5" w:uiPriority="52"/>
				<w:lsdException w:name="List Table 1 Light Accent 6" w:uiPriority="46"/>
				<w:lsdException w:name="List Table 2 Accent 6" w:uiPriority="47"/>
				<w:lsdException w:name="List Table 3 Accent 6" w:uiPriority="48"/>
				<w:lsdException w:name="List Table 4 Accent 6" w:uiPriority="49"/>
				<w:lsdException w:name="List Table 5 Dark Accent 6" w:uiPriority="50"/>
				<w:lsdException w:name="List Table 6 Colorful Accent 6" w:uiPriority="51"/>
				<w:lsdException w:name="List Table 7 Colorful Accent 6" w:uiPriority="52"/>
			</w:latentStyles>
			<w:style w:type="paragraph" w:default="1" w:styleId="a">
				<w:name w:val="Normal"/>
				<w:qFormat/>
				<w:pPr>
					<w:widowControl w:val="0"/>
					<w:jc w:val="both"/>
				</w:pPr>
			</w:style>
			<w:style w:type="character" w:default="1" w:styleId="a0">
				<w:name w:val="Default Paragraph Font"/>
				<w:uiPriority w:val="1"/>
				<w:semiHidden/>
				<w:unhideWhenUsed/>
			</w:style>
			<w:style w:type="table" w:default="1" w:styleId="a1">
				<w:name w:val="Normal Table"/>
				<w:uiPriority w:val="99"/>
				<w:semiHidden/>
				<w:unhideWhenUsed/>
				<w:tblPr>
					<w:tblInd w:w="0" w:type="dxa"/>
					<w:tblCellMar>
						<w:top w:w="0" w:type="dxa"/>
						<w:left w:w="108" w:type="dxa"/>
						<w:bottom w:w="0" w:type="dxa"/>
						<w:right w:w="108" w:type="dxa"/>
					</w:tblCellMar>
				</w:tblPr>
			</w:style>
			<w:style w:type="numbering" w:default="1" w:styleId="a2">
				<w:name w:val="No List"/>
				<w:uiPriority w:val="99"/>
				<w:semiHidden/>
				<w:unhideWhenUsed/>
			</w:style>
		</w:styles>
	</pkg:xmlData>
</pkg:part>
</pkg:package>
