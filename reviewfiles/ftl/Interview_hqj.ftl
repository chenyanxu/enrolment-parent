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
					<w:p w:rsidR="00D911A4" w:rsidRDefault="004E3488">
						<#assign questionType1 = ""/>
						<#assign questionStem1 = ""/>
						<#assign questionType2 = ""/>
						<#assign questionStem2 = ""/>
						<#list quesList as ques>
							<#list (ques.question)! as question>
								<#if question_index = 0>
									<#assign questionType1 = "${question.type!}"/>
									<#assign questionStem1 = "${question.stem!}"/>
								</#if>
								<#if question_index = 1>
									<#assign questionType2 = "${question.type!}"/>
									<#assign questionStem2 = "${question.stem!}"/>
									<#break>
								</#if>
							</#list>
						</#list>
						<w:r>
							<w:rPr>
								<w:noProof/>
							</w:rPr>
							<mc:AlternateContent>
								<mc:Choice Requires="wps">
									<w:drawing>
										<wp:anchor distT="45720" distB="45720" distL="114300" distR="114300" simplePos="0" relativeHeight="251659264" behindDoc="0" locked="0" layoutInCell="1" allowOverlap="1" wp14:anchorId="6CBE2730" wp14:editId="55F25812">
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
											<wp:docPr id="217" name="文本框 2"/><wp:cNvGraphicFramePr>
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
																	<w:t>${questionType1!}</w:t></w:r>
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
										<v:shapetype w14:anchorId="6CBE2730" id="_x0000_t202" coordsize="21600,21600" o:spt="202" path="m,l,21600r21600,l21600,xe">
											<v:stroke joinstyle="miter"/>
											<v:path gradientshapeok="t" o:connecttype="rect"/>
										</v:shapetype>
										<v:shape id="文本框 2" o:spid="_x0000_s1026" type="#_x0000_t202" style="position:absolute;left:0;text-align:left;margin-left:0pt;margin-top:5pt;width:180pt;height:35pt;z-index:251659264;visibility:visible;mso-wrap-style:square;mso-width-percent:0;mso-height-percent:0;mso-wrap-distance-left:9pt;mso-wrap-distance-top:3.6pt;mso-wrap-distance-right:9pt;mso-wrap-distance-bottom:3.6pt;mso-position-horizontal:absolute;mso-position-horizontal-relative:text;mso-position-vertical:absolute;mso-position-vertical-relative:text;mso-width-percent:0;mso-height-percent:0;mso-width-relative:margin;mso-height-relative:margin;v-text-anchor:top" o:gfxdata="UEsDBBQABgAIAAAAIQC2gziS/gAAAOEBAAATAAAAW0NvbnRlbnRfVHlwZXNdLnhtbJSRQU7DMBBF&#xA;90jcwfIWJU67QAgl6YK0S0CoHGBkTxKLZGx5TGhvj5O2G0SRWNoz/78nu9wcxkFMGNg6quQqL6RA&#xA;0s5Y6ir5vt9lD1JwBDIwOMJKHpHlpr69KfdHjyxSmriSfYz+USnWPY7AufNIadK6MEJMx9ApD/oD&#xA;OlTrorhX2lFEilmcO2RdNtjC5xDF9pCuTyYBB5bi6bQ4syoJ3g9WQ0ymaiLzg5KdCXlKLjvcW893&#xA;SUOqXwnz5DrgnHtJTxOsQfEKIT7DmDSUCaxw7Rqn8787ZsmRM9e2VmPeBN4uqYvTtW7jvijg9N/y&#xA;JsXecLq0q+WD6m8AAAD//wMAUEsDBBQABgAIAAAAIQA4/SH/1gAAAJQBAAALAAAAX3JlbHMvLnJl&#xA;bHOkkMFqwzAMhu+DvYPRfXGawxijTi+j0GvpHsDYimMaW0Yy2fr2M4PBMnrbUb/Q94l/f/hMi1qR&#xA;JVI2sOt6UJgd+ZiDgffL8ekFlFSbvV0oo4EbChzGx4f9GRdb25HMsYhqlCwG5lrLq9biZkxWOiqY&#xA;22YiTra2kYMu1l1tQD30/bPm3wwYN0x18gb45AdQl1tp5j/sFB2T0FQ7R0nTNEV3j6o9feQzro1i&#xA;OWA14Fm+Q8a1a8+Bvu/d/dMb2JY5uiPbhG/ktn4cqGU/er3pcvwCAAD//wMAUEsDBBQABgAIAAAA&#xA;IQB0lTimHAIAAPUDAAAOAAAAZHJzL2Uyb0RvYy54bWysU0tu2zAQ3RfoHQjua1mqHTuC5SBNmqJA&#xA;+gHSHoCmKIsoyWFJ2pJ7gPYGXXWTfc7lc3RIOY7R7opqQXA0M2/mvRkuLnqtyFY4L8FUNB+NKRGG&#xA;Qy3NuqKfP928mFPiAzM1U2BERXfC04vl82eLzpaigBZULRxBEOPLzla0DcGWWeZ5KzTzI7DCoLMB&#xA;p1lA062z2rEO0bXKivH4LOvA1dYBF97j3+vBSZcJv2kEDx+axotAVEWxt5BOl85VPLPlgpVrx2wr&#xA;+aEN9g9daCYNFj1CXbPAyMbJv6C05A48NGHEQWfQNJKLxAHZ5OM/2Ny1zIrEBcXx9iiT/3+w/P32&#xA;oyOyrmiRzygxTOOQ9j9/7H897O+/kyIK1FlfYtydxcjQv4IeB53IensL/IsnBq5aZtbi0jnoWsFq&#xA;bDCPmdlJ6oDjI8iqewc11mGbAAmob5yO6qEeBNFxULvjcEQfCMefRXGWz2fo4uibvJzNZ0MJVj5m&#xA;W+fDGwGaxEtFHQ4/obPtrQ+x
											G1Y+hsRiBm6kUmkBlCFdRc+nxTQlnHi0DLifSuqKzsfxGzYmknxt&#xA;6pQcmFTDHQsoc2AdiQ6UQ7/qMTBKsYJ6h/wdDHuI7wYvLbhvlHS4gxX1XzfMCUrUW4ManueTSVza&#xA;ZEymswINd+pZnXqY4QhV0UDJcL0KadEHrpeodSOTDE+dHHrF3UrqHN5BXN5TO0U9vdblbwAAAP//&#xA;AwBQSwMEFAAGAAgAAAAhAEooIYvZAAAABQEAAA8AAABkcnMvZG93bnJldi54bWxMjstOwzAQRfdI&#xA;/IM1SOyoXSiBhEwqBGILojwkdtN4mkTE4yh2m/D3uCtY3ofuPeV6dr068Bg6LwjLhQHFUnvbSYPw&#xA;/vZ0cQsqRBJLvRdG+OEA6+r0pKTC+kle+bCJjUojEgpCaGMcCq1D3bKjsPADS8p2fnQUkxwbbUea&#xA;0rjr9aUxmXbUSXpoaeCHluvvzd4hfDzvvj5X5qV5dNfD5GejxeUa8fxsvr8DFXmOf2U44id0qBLT&#xA;1u/FBtUjrG5S8WirFF5lJge1RcjyJeiq1P/pq18AAAD//wMAUEsBAi0AFAAGAAgAAAAhALaDOJL+&#xA;AAAA4QEAABMAAAAAAAAAAAAAAAAAAAAAAFtDb250ZW50X1R5cGVzXS54bWxQSwECLQAUAAYACAAA&#xA;ACEAOP0h/9YAAACUAQAACwAAAAAAAAAAAAAAAAAvAQAAX3JlbHMvLnJlbHNQSwECLQAUAAYACAAA&#xA;ACEAdJU4phwCAAD1AwAADgAAAAAAAAAAAAAAAAAuAgAAZHJzL2Uyb0RvYy54bWxQSwECLQAUAAYA&#xA;CAAAACEASighi9kAAAAFAQAADwAAAAAAAAAAAAAAAAB2BAAAZHJzL2Rvd25yZXYueG1sUEsFBgAA&#xA;AAAEAAQA8wAAAHwFAAAAAA==&#xA;" filled="f" stroked="f">
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
															<w:t>${questionType1!}</w:t></w:r>
														</w:p>
													</w:txbxContent>
												</v:textbox>
												<w10:wrap type="square"/>
											</v:shape>
										</w:pict>
									</mc:Fallback>
								</mc:AlternateContent>
						</w:r>
						<w:r w:rsidR="00BF692D">
								<w:rPr>
									<w:noProof/>
								</w:rPr>
								<mc:AlternateContent>
									<mc:Choice Requires="wps">
										<w:drawing>
											<wp:anchor distT="45720" distB="45720" distL="114300" distR="114300" simplePos="0" relativeHeight="251661312" behindDoc="0" locked="0" layoutInCell="1" allowOverlap="1" wp14:anchorId="7F163FC3" wp14:editId="13992869">
												<wp:simplePos x="0" y="0"/>
												<wp:positionH relativeFrom="column">
													<wp:posOffset>83185</wp:posOffset>
												</wp:positionH>
												<wp:positionV relativeFrom="paragraph">
													<wp:posOffset>448849</wp:posOffset>
												</wp:positionV>
												<wp:extent cx="5116195" cy="3091815"/>
												<wp:effectExtent l="0" t="0" r="0" b="0"/>
												<wp:wrapSquare wrapText="bothSides"/>
												<wp:docPr id="1" name="文本框 2"/><wp:cNvGraphicFramePr>
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
																<a:ext cx="5116195" cy="3091815"/>
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
																<w:p w:rsidR="00793991" w:rsidRPr="00067A27" w:rsidRDefault="00067A27" w:rsidP="00067A27">
																	<w:pPr>
																		<w:spacing w:line="360" w:lineRule="auto"/>
																		<w:rPr>
																			<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体"/><w:bCs/>
																		<w:sz w:val="24"/>
																	</w:rPr>
																</w:pPr>
																<w:r>
																	<w:rPr>
																		<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体" w:hint="eastAsia"/><w:bCs/>
																	<w:sz w:val="24"/>
																</w:rPr>
																<w:t>题目：${questionStem1!}</w:t></w:r>
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
								<v:shapetype w14:anchorId="7F163FC3" id="_x0000_t202" coordsize="21600,21600" o:spt="202" path="m,l,21600r21600,l21600,xe">
									<v:stroke joinstyle="miter"/>
									<v:path gradientshapeok="t" o:connecttype="rect"/>
								</v:shapetype>
								<v:shape id="_x0000_s1027" type="#_x0000_t202" style="position:absolute;left:0;text-align:left;margin-left:0pt;margin-top:65pt;width:400pt;height:300pt;z-index:251661312;visibility:visible;mso-wrap-style:square;mso-width-percent:0;mso-height-percent:0;mso-wrap-distance-left:9pt;mso-wrap-distance-top:3.6pt;mso-wrap-distance-right:9pt;mso-wrap-distance-bottom:3.6pt;mso-position-horizontal:absolute;mso-position-horizontal-relative:text;mso-position-vertical:absolute;mso-position-vertical-relative:text;mso-width-percent:0;mso-height-percent:0;mso-width-relative:margin;mso-height-relative:margin;v-text-anchor:middle" o:gfxdata="UEsDBBQABgAIAAAAIQC2gziS/gAAAOEBAAATAAAAW0NvbnRlbnRfVHlwZXNdLnhtbJSRQU7DMBBF&#xA;90jcwfIWJU67QAgl6YK0S0CoHGBkTxKLZGx5TGhvj5O2G0SRWNoz/78nu9wcxkFMGNg6quQqL6RA&#xA;0s5Y6ir5vt9lD1JwBDIwOMJKHpHlpr69KfdHjyxSmriSfYz+USnWPY7AufNIadK6MEJMx9ApD/oD&#xA;OlTrorhX2lFEilmcO2RdNtjC5xDF9pCuTyYBB5bi6bQ4syoJ3g9WQ0ymaiLzg5KdCXlKLjvcW893&#xA;SUOqXwnz5DrgnHtJTxOsQfEKIT7DmDSUCaxw7Rqn8787ZsmRM9e2VmPeBN4uqYvTtW7jvijg9N/y&#xA;JsXecLq0q+WD6m8AAAD//wMAUEsDBBQABgAIAAAAIQA4/SH/1gAAAJQBAAALAAAAX3JlbHMvLnJl&#xA;bHOkkMFqwzAMhu+DvYPRfXGawxijTi+j0GvpHsDYimMaW0Yy2fr2M4PBMnrbUb/Q94l/f/hMi1qR&#xA;JVI2sOt6UJgd+ZiDgffL8ekFlFSbvV0oo4EbChzGx4f9GRdb25HMsYhqlCwG5lrLq9biZkxWOiqY&#xA;22YiTra2kYMu1l1tQD30/bPm3wwYN0x18gb45AdQl1tp5j/sFB2T0FQ7R0nTNEV3j6o9feQzro1i&#xA;OWA14Fm+Q8a1a8+Bvu/d/dMb2JY5uiPbhG/ktn4cqGU/er3pcvwCAAD//wMAUEsDBBQABgAIAAAA&#xA;IQDlELkHHgIAAP0DAAAOAAAAZHJzL2Uyb0RvYy54bWysU82O0zAQviPxDpbvNElpljZqulp2WYS0&#xA;/EgLD+A6TmNhe4ztNlkeYHkDTly481x9DsZOt1vBDZGD5cnMfDPfN+Pl+aAV2QnnJZiaFpOcEmE4&#xA;NNJsavrp4/WzOSU+MNMwBUbU9E54er56+mTZ20pMoQPVCEcQxPiqtzXtQrBVlnneCc38BKww6GzB&#xA;aRbQdJuscaxHdK2yaZ6fZT24xjrgwnv8ezU66Srht63g4X3behGIqin2FtLp0rmOZ7ZasmrjmO0k&#xA;P7TB/qELzaTBokeoKxYY2Tr5F5SW3IGHNkw46AzaVnKROCCbIv+DzW3HrEhcUBxvjzL5/wfL3+0+&#xA;OCIbnB0lhmkc0f77t/2PX/uf92Qa5emtrzDq1mJcGF7CEEMjVW9vgH/2xMBlx8xGXDgHfSdYg+0V&#xA;MTM7SR1xfARZ92+hwTpsGyABDa3TERDVIIiOY7o7jkYMgXD8WRbFWbEoKeHoe54vinlRphqseki3&#xA;zofXAjSJl5o6nH2CZ7sbH2I7rHoI
									idUMXEul0vyVIX1NF+W0TAknHi0DrqeSuqbzPH7jwkSWr0yT&#xA;kgOTarxjAWUOtCPTkXMY1sNBYIyPkqyhuUMdHIzbiK8HLx24r5T0uIk19V+2zAlK1BuDWi6K2Syu&#xA;bjJm5YspGu7Usz71MMMRqqY8OEpG4zKkhR9JX6DqrUx6PPZyaBp3LMl0eA9xiU/tFPX4ale/AQAA&#xA;//8DAFBLAwQUAAYACAAAACEAfdJZ4t4AAAAJAQAADwAAAGRycy9kb3ducmV2LnhtbEyPQUvDQBSE&#xA;74L/YXkFL2I3UZqENJsiQkGKHqz+gE32NRuafRuy2zT+e58nPQ4zzHxT7RY3iBmn0HtSkK4TEEit&#xA;Nz11Cr4+9w8FiBA1GT14QgXfGGBX395UujT+Sh84H2MnuIRCqRXYGMdSytBadDqs/YjE3slPTkeW&#xA;UyfNpK9c7gb5mCSZdLonXrB6xBeL7fl4cQru7Zi8v51em73JWns+BJ27+aDU3Wp53oKIuMS/MPzi&#xA;MzrUzNT4C5kgBtZPKScV5EkOgv0iLfhKo2CzyTOQdSX/P6h/AAAA//8DAFBLAQItABQABgAIAAAA&#xA;IQC2gziS/gAAAOEBAAATAAAAAAAAAAAAAAAAAAAAAABbQ29udGVudF9UeXBlc10ueG1sUEsBAi0A&#xA;FAAGAAgAAAAhADj9If/WAAAAlAEAAAsAAAAAAAAAAAAAAAAALwEAAF9yZWxzLy5yZWxzUEsBAi0A&#xA;FAAGAAgAAAAhAOUQuQceAgAA/QMAAA4AAAAAAAAAAAAAAAAALgIAAGRycy9lMm9Eb2MueG1sUEsB&#xA;Ai0AFAAGAAgAAAAhAH3SWeLeAAAACQEAAA8AAAAAAAAAAAAAAAAAeAQAAGRycy9kb3ducmV2Lnht&#xA;bFBLBQYAAAAABAAEAPMAAACDBQAAAAA=&#xA;" filled="f" stroked="f">
									<v:textbox>
										<w:txbxContent>
											<w:p w:rsidR="00793991" w:rsidRPr="00067A27" w:rsidRDefault="00067A27" w:rsidP="00067A27">
												<w:pPr>
													<w:spacing w:line="360" w:lineRule="auto"/>
													<w:rPr>
														<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体"/><w:bCs/>
													<w:sz w:val="24"/>
												</w:rPr>
											</w:pPr>
											<w:r>
												<w:rPr>
													<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体" w:hint="eastAsia"/><w:bCs/>
												<w:sz w:val="24"/>
											</w:rPr>
											<w:t>题目：${questionStem1!}</w:t></w:r>
										<w:bookmarkStart w:id="1" w:name="_GoBack"/>
										<w:bookmarkEnd w:id="1"/>
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
				<wp:anchor distT="45720" distB="45720" distL="114300" distR="114300" simplePos="0" relativeHeight="251658239" behindDoc="0" locked="0" layoutInCell="1" allowOverlap="1" wp14:anchorId="1754116D" wp14:editId="0F2D3062">
					<wp:simplePos x="0" y="0"/>
					<wp:positionH relativeFrom="column">
						<wp:posOffset>-1905</wp:posOffset>
					</wp:positionH>
					<wp:positionV relativeFrom="paragraph">
						<wp:posOffset>4870806</wp:posOffset>
					</wp:positionV>
					<wp:extent cx="2360930" cy="411480"/>
					<wp:effectExtent l="0" t="0" r="0" b="0"/>
					<wp:wrapSquare wrapText="bothSides"/>
					<wp:docPr id="3" name="文本框 2"/><wp:cNvGraphicFramePr>
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
											<w:t>${questionType2!}</w:t></w:r>
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
				<v:shapetype w14:anchorId="0D8DEBCB" id="_x0000_t202" coordsize="21600,21600" o:spt="202" path="m,l,21600r21600,l21600,xe">
					<v:stroke joinstyle="miter"/>
					<v:path gradientshapeok="t" o:connecttype="rect"/>
				</v:shapetype>
				<v:shape id="_x0000_s1028" type="#_x0000_t202" style="position:absolute;left:0;text-align:left;margin-left:0pt;margin-top:335pt;width:180pt;height:35pt;z-index:251658239;visibility:visible;mso-wrap-style:square;mso-width-percent:400;mso-height-percent:0;mso-wrap-distance-left:9pt;mso-wrap-distance-top:3.6pt;mso-wrap-distance-right:9pt;mso-wrap-distance-bottom:3.6pt;mso-position-horizontal:absolute;mso-position-horizontal-relative:text;mso-position-vertical:absolute;mso-position-vertical-relative:text;mso-width-percent:400;mso-height-percent:0;mso-width-relative:margin;mso-height-relative:margin;v-text-anchor:top" o:gfxdata="UEsDBBQABgAIAAAAIQC2gziS/gAAAOEBAAATAAAAW0NvbnRlbnRfVHlwZXNdLnhtbJSRQU7DMBBF&#xA;90jcwfIWJU67QAgl6YK0S0CoHGBkTxKLZGx5TGhvj5O2G0SRWNoz/78nu9wcxkFMGNg6quQqL6RA&#xA;0s5Y6ir5vt9lD1JwBDIwOMJKHpHlpr69KfdHjyxSmriSfYz+USnWPY7AufNIadK6MEJMx9ApD/oD&#xA;OlTrorhX2lFEilmcO2RdNtjC5xDF9pCuTyYBB5bi6bQ4syoJ3g9WQ0ymaiLzg5KdCXlKLjvcW893&#xA;SUOqXwnz5DrgnHtJTxOsQfEKIT7DmDSUCaxw7Rqn8787ZsmRM9e2VmPeBN4uqYvTtW7jvijg9N/y&#xA;JsXecLq0q+WD6m8AAAD//wMAUEsDBBQABgAIAAAAIQA4/SH/1gAAAJQBAAALAAAAX3JlbHMvLnJl&#xA;bHOkkMFqwzAMhu+DvYPRfXGawxijTi+j0GvpHsDYimMaW0Yy2fr2M4PBMnrbUb/Q94l/f/hMi1qR&#xA;JVI2sOt6UJgd+ZiDgffL8ekFlFSbvV0oo4EbChzGx4f9GRdb25HMsYhqlCwG5lrLq9biZkxWOiqY&#xA;22YiTra2kYMu1l1tQD30/bPm3wwYN0x18gb45AdQl1tp5j/sFB2T0FQ7R0nTNEV3j6o9feQzro1i&#xA;OWA14Fm+Q8a1a8+Bvu/d/dMb2JY5uiPbhG/ktn4cqGU/er3pcvwCAAD//wMAUEsDBBQABgAIAAAA&#xA;IQCERprFHQIAAPoDAAAOAAAAZHJzL2Uyb0RvYy54bWysU82O0zAQviPxDpbvNEl/ljZqulp2WYS0&#xA;/EgLD+A6TmNhe4ztNikPsLwBJy7cea4+B2OnWyq4IXKwPJmZb+b7Zry87LUiO+G8BFPRYpRTIgyH&#xA;WppNRT9+uH02p8QHZmqmwIiK7oWnl6unT5adLcUYWlC1cARBjC87W9E2BFtmmeet0MyPwAqDzgac&#xA;ZgFNt8lqxzpE1yob5/lF1oGrrQMuvMe/N4OTrhJ+0wge3jWNF4GoimJvIZ0unet4ZqslKzeO2Vby&#xA;YxvsH7rQTBoseoK6YYGRrZN/QWnJHXhowoiDzqBpJBeJA7Ip8j/Y3LfMisQFxfH2JJP/f7D87e69&#xA;I7Ku6IQSwzSO6PDt6+H7z8OPBzKO8nTWlxh1bzEu9C+gxzEnqt7eAf/kiYHrlpmNuHIOulawGtsr&#xA;YmZ2ljrg+Aiy7t5AjXXYNkAC6huno3aoBkF0HNP+NBrRB8Lx53hykS8m6OLomxbFdJ5ml7HyMds6&#xA;H14J0CReKupw9Amd7e58iN2w8jEkF
					jNwK5VK41eGdBVdzMazlHDm0TLgdiqpKzrP4zfsSyT50tQp&#xA;OTCphjsWUObIOhIdKId+3Sd9T2Kuod6jDA6GZcTHg5cW3BdKOlzEivrPW+YEJeq1QSkXxXQaNzcZ&#xA;09nzMRru3LM+9zDDEaqigZLheh3Stg+Ur1DyRiY14myGTo4t44IlkY6PIW7wuZ2ifj/Z1S8AAAD/&#xA;/wMAUEsDBBQABgAIAAAAIQC8ckjb4AAAAAkBAAAPAAAAZHJzL2Rvd25yZXYueG1sTI/NTsMwEITv&#xA;SLyDtUjcWieENG2aTYVQOSBxKKXcXXvzA7EdxU4aeHrMCY6jGc18U+xm3bGJBtdagxAvI2BkpFWt&#xA;qRFOb0+LNTDnhVGis4YQvsjBrry+KkSu7MW80nT0NQslxuUCofG+zzl3siEt3NL2ZIJX2UELH+RQ&#xA;czWISyjXHb+LohXXojVhoRE9PTYkP4+jRqie3zP9cl/tT/sx/f6YUjkfaol4ezM/bIF5mv1fGH7x&#xA;AzqUgelsR6Mc6xAWSQgiZKssBhb8JItTYGeEdRJvgJcF//+g/AEAAP//AwBQSwECLQAUAAYACAAA&#xA;ACEAtoM4kv4AAADhAQAAEwAAAAAAAAAAAAAAAAAAAAAAW0NvbnRlbnRfVHlwZXNdLnhtbFBLAQIt&#xA;ABQABgAIAAAAIQA4/SH/1gAAAJQBAAALAAAAAAAAAAAAAAAAAC8BAABfcmVscy8ucmVsc1BLAQIt&#xA;ABQABgAIAAAAIQCERprFHQIAAPoDAAAOAAAAAAAAAAAAAAAAAC4CAABkcnMvZTJvRG9jLnhtbFBL&#xA;AQItABQABgAIAAAAIQC8ckjb4AAAAAkBAAAPAAAAAAAAAAAAAAAAAHcEAABkcnMvZG93bnJldi54&#xA;bWxQSwUGAAAAAAQABADzAAAAhAUAAAAA&#xA;" filled="f" stroked="f">
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
									<w:t>${questionType2!}</w:t></w:r>
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
						<wp:anchor distT="45720" distB="45720" distL="114300" distR="114300" simplePos="0" relativeHeight="251657214" behindDoc="0" locked="0" layoutInCell="1" allowOverlap="1" wp14:anchorId="75AFEE54" wp14:editId="7956F078">
							<wp:simplePos x="0" y="0"/>
							<wp:positionH relativeFrom="column">
								<wp:posOffset>83185</wp:posOffset>
							</wp:positionH>
							<wp:positionV relativeFrom="paragraph">
								<wp:posOffset>5512435</wp:posOffset>
							</wp:positionV>
							<wp:extent cx="5121275" cy="3133725"/>
							<wp:effectExtent l="0" t="0" r="0" b="0"/>
							<wp:wrapSquare wrapText="bothSides"/>
							<wp:docPr id="4" name="文本框 2"/><wp:cNvGraphicFramePr>
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
											<a:ext cx="5121275" cy="3133725"/>
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
											<w:p w:rsidR="00793991" w:rsidRPr="00067A27" w:rsidRDefault="00793991" w:rsidP="00067A27">
												<w:pPr>
													<w:spacing w:line="360" w:lineRule="auto"/>
													<w:jc w:val="left"/>
													<w:rPr>
														<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体"/><w:bCs/>
													<w:sz w:val="24"/>
												</w:rPr>
											</w:pPr>
											<w:r w:rsidRPr="00067A27">
												<w:rPr>
													<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体"/><w:bCs/>
												<w:sz w:val="24"/>
											</w:rPr>
											<w:t>题目：${questionStem2!}</w:t></w:r>
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
			<v:shape w14:anchorId="75AFEE54" id="_x0000_s1028" type="#_x0000_t202" style="position:absolute;left:0;text-align:left;margin-left:0pt;margin-top:395pt;width:400pt;height:300pt;z-index:251657214;visibility:visible;mso-wrap-style:square;mso-width-percent:0;mso-height-percent:0;mso-wrap-distance-left:9pt;mso-wrap-distance-top:3.6pt;mso-wrap-distance-right:9pt;mso-wrap-distance-bottom:3.6pt;mso-position-horizontal:absolute;mso-position-horizontal-relative:text;mso-position-vertical:absolute;mso-position-vertical-relative:text;mso-width-percent:0;mso-height-percent:0;mso-width-relative:margin;mso-height-relative:margin;v-text-anchor:middle" o:gfxdata="UEsDBBQABgAIAAAAIQC2gziS/gAAAOEBAAATAAAAW0NvbnRlbnRfVHlwZXNdLnhtbJSRQU7DMBBF&#xA;90jcwfIWJU67QAgl6YK0S0CoHGBkTxKLZGx5TGhvj5O2G0SRWNoz/78nu9wcxkFMGNg6quQqL6RA&#xA;0s5Y6ir5vt9lD1JwBDIwOMJKHpHlpr69KfdHjyxSmriSfYz+USnWPY7AufNIadK6MEJMx9ApD/oD&#xA;OlTrorhX2lFEilmcO2RdNtjC5xDF9pCuTyYBB5bi6bQ4syoJ3g9WQ0ymaiLzg5KdCXlKLjvcW893&#xA;SUOqXwnz5DrgnHtJTxOsQfEKIT7DmDSUCaxw7Rqn8787ZsmRM9e2VmPeBN4uqYvTtW7jvijg9N/y&#xA;JsXecLq0q+WD6m8AAAD//wMAUEsDBBQABgAIAAAAIQA4/SH/1gAAAJQBAAALAAAAX3JlbHMvLnJl&#xA;bHOkkMFqwzAMhu+DvYPRfXGawxijTi+j0GvpHsDYimMaW0Yy2fr2M4PBMnrbUb/Q94l/f/hMi1qR&#xA;JVI2sOt6UJgd+ZiDgffL8ekFlFSbvV0oo4EbChzGx4f9GRdb25HMsYhqlCwG5lrLq9biZkxWOiqY&#xA;22YiTra2kYMu1l1tQD30/bPm3wwYN0x18gb45AdQl1tp5j/sFB2T0FQ7R0nTNEV3j6o9feQzro1i&#xA;OWA14Fm+Q8a1a8+Bvu/d/dMb2JY5uiPbhG/ktn4cqGU/er3pcvwCAAD//wMAUEsDBBQABgAIAAAA&#xA;IQCJNRdTHgIAAP0DAAAOAAAAZHJzL2Uyb0RvYy54bWysU0tu2zAQ3RfoHQjua1myXSeC5SBNmqJA&#xA;+gHSHoCmKIsoyWFJ2pJ7gPYGXXWTfc7lc3RIOa6R7opqQXA0M2/mvRkuLnqtyFY4L8FUNB+NKRGG&#xA;Qy3NuqKfP928OKPEB2ZqpsCIiu6EpxfL588WnS1FAS2oWjiCIMaXna1oG4Its8zzVmjmR2CFQWcD&#xA;TrOApltntWMdomuVFePxy6wDV1sHXHiPf68HJ10m/KYRPHxoGi8CURXF3kI6XTpX8cyWC1auHbOt&#xA;5Ic22D90oZk0WPQIdc0CIxsn/4LSkjvw0IQRB51B00guEgdkk4+fsLlrmRWJC4rj7VEm//9g+fvt&#xA;R0dkXdEpJYZpHNH+54/9r4f9/XdSRHk660uMurMYF/pX0OOYE1Vvb4F/8cTAVcvMWlw6B10rWI3t&#xA;5TEzO0kdcHwEWXXvoMY6bBMgAfWN01E7VIMgOo5pdxyN6APh+HOWF3kxn1HC0TfJJ5N5MUs1WPmY&#xA;bp0
				PbwRoEi8VdTj7BM+2tz7Edlj5GBKrGbiRSqX5K0O6ip7PEPKJR8uA66mkrujZOH7DwkSWr02d&#xA;kgOTarhjAWUOtCPTgXPoV30S+KjmCuod6uBg2EZ8PXhpwX2jpMNNrKj/umFOUKLeGtTyPJ9O4+om&#xA;YzqbF2i4U8/q1MMMR6iK8uAoGYyrkBZ+oHaJqjcy6RHHM/RyaBp3LMl0eA9xiU/tFPXn1S5/AwAA&#xA;//8DAFBLAwQUAAYACAAAACEAnyi/194AAAALAQAADwAAAGRycy9kb3ducmV2LnhtbEyPwU7DMBBE&#xA;70j8g7VIXBB1ApIJIU6FkCqhCg4tfMAmduOo8TqK3TT8PdsT3HY0T7Mz1Xrxg5jtFPtAGvJVBsJS&#xA;G0xPnYbvr819ASImJINDIKvhx0ZY19dXFZYmnGln533qBIdQLFGDS2kspYytsx7jKoyW2DuEyWNi&#xA;OXXSTHjmcD/IhyxT0mNP/MHhaN+cbY/7k9dw58bs8+Pw3myMat1xG/HJz1utb2+W1xcQyS7pD4ZL&#xA;fa4ONXdqwolMFAPrx5xJDYUq+GCgyJ8ViObiqFyBrCv5f0P9CwAA//8DAFBLAQItABQABgAIAAAA&#xA;IQC2gziS/gAAAOEBAAATAAAAAAAAAAAAAAAAAAAAAABbQ29udGVudF9UeXBlc10ueG1sUEsBAi0A&#xA;FAAGAAgAAAAhADj9If/WAAAAlAEAAAsAAAAAAAAAAAAAAAAALwEAAF9yZWxzLy5yZWxzUEsBAi0A&#xA;FAAGAAgAAAAhAIk1F1MeAgAA/QMAAA4AAAAAAAAAAAAAAAAALgIAAGRycy9lMm9Eb2MueG1sUEsB&#xA;Ai0AFAAGAAgAAAAhAJ8ov9feAAAACwEAAA8AAAAAAAAAAAAAAAAAeAQAAGRycy9kb3ducmV2Lnht&#xA;bFBLBQYAAAAABAAEAPMAAACDBQAAAAA=&#xA;" filled="f" stroked="f">
				<v:textbox>
					<w:txbxContent>
						<w:p w:rsidR="00793991" w:rsidRPr="00067A27" w:rsidRDefault="00793991" w:rsidP="00067A27">
							<w:pPr>
								<w:spacing w:line="360" w:lineRule="auto"/>
								<w:jc w:val="left"/>
								<w:rPr>
									<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体"/><w:bCs/>
								<w:sz w:val="24"/>
							</w:rPr>
						</w:pPr>
						<w:r w:rsidRPr="00067A27">
							<w:rPr>
								<w:rFonts w:ascii="宋体" w:hAnsi="宋体" w:cs="宋体"/><w:bCs/>
							<w:sz w:val="24"/>
						</w:rPr>
						<w:t>题目：${questionStem2!}</w:t></w:r>
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
							<wp:posOffset>-1525905</wp:posOffset>
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
				<v:line w14:anchorId="43F13D54" id="直接连接符 2" o:spid="_x0000_s1026" style="position:absolute;left:0;text-align:left;flip:y;z-index:-251654144;visibility:visible;mso-wrap-style:square;mso-width-percent:0;mso-height-percent:0;mso-wrap-distance-left:9pt;mso-wrap-distance-top:0;mso-wrap-distance-right:9pt;mso-wrap-distance-bottom:0;mso-position-horizontal:absolute;mso-position-horizontal-relative:text;mso-position-vertical:absolute;mso-position-vertical-relative:text;mso-width-percent:0;mso-height-percent:0;mso-width-relative:page;mso-height-relative:page" from="-120.15pt,342.65pt" to="587.85pt,344.85pt" o:gfxdata="UEsDBBQABgAIAAAAIQC2gziS/gAAAOEBAAATAAAAW0NvbnRlbnRfVHlwZXNdLnhtbJSRQU7DMBBF&#xA;90jcwfIWJU67QAgl6YK0S0CoHGBkTxKLZGx5TGhvj5O2G0SRWNoz/78nu9wcxkFMGNg6quQqL6RA&#xA;0s5Y6ir5vt9lD1JwBDIwOMJKHpHlpr69KfdHjyxSmriSfYz+USnWPY7AufNIadK6MEJMx9ApD/oD&#xA;OlTrorhX2lFEilmcO2RdNtjC5xDF9pCuTyYBB5bi6bQ4syoJ3g9WQ0ymaiLzg5KdCXlKLjvcW893&#xA;SUOqXwnz5DrgnHtJTxOsQfEKIT7DmDSUCaxw7Rqn8787ZsmRM9e2VmPeBN4uqYvTtW7jvijg9N/y&#xA;JsXecLq0q+WD6m8AAAD//wMAUEsDBBQABgAIAAAAIQA4/SH/1gAAAJQBAAALAAAAX3JlbHMvLnJl&#xA;bHOkkMFqwzAMhu+DvYPRfXGawxijTi+j0GvpHsDYimMaW0Yy2fr2M4PBMnrbUb/Q94l/f/hMi1qR&#xA;JVI2sOt6UJgd+ZiDgffL8ekFlFSbvV0oo4EbChzGx4f9GRdb25HMsYhqlCwG5lrLq9biZkxWOiqY&#xA;22YiTra2kYMu1l1tQD30/bPm3wwYN0x18gb45AdQl1tp5j/sFB2T0FQ7R0nTNEV3j6o9feQzro1i&#xA;OWA14Fm+Q8a1a8+Bvu/d/dMb2JY5uiPbhG/ktn4cqGU/er3pcvwCAAD//wMAUEsDBBQABgAIAAAA&#xA;IQCl2FOc9AEAALYDAAAOAAAAZHJzL2Uyb0RvYy54bWysU81uEzEQviPxDpbvZJOItskqmx4ayqWC&#xA;SAXuE9ubtfCfPCabvAQvgMQNThx7521oH6NjJ6QULgixh5HtGX8z3+dvZ+dba9hGRdTeNXw0GHKm&#xA;nPBSu3XD3765fDbhDBM4CcY71fCdQn4+f/pk1odajX3njVSREYjDug8N71IKdVWh6JQFHPigHCVb&#xA;Hy0k2sZ1JSP0hG5NNR4OT6veRxmiFwqRThf7JJ8X/LZVIr1uW1SJmYbTbKnEWOIqx2o+g3odIXRa&#xA;HMaAf5jCgnbU9Ai1gATsQ9R/QFktokffpoHwtvJtq4UqHIjNaPgbm+sOgipcSBwMR5nw/8GKV5tl&#xA;ZFo2fMyZA0tPdPvp5sfHL3ffP1O8/faVjbNIfcCaai/cMmaaYuuuw5UX75Fy1aNk3mDYl23baFlr&#xA;dHhH3ij6EGO2LfLvjvKrbWKCDifT6eh0SK8kKDc+mz4vz1NBnWFy1xAxvVTesrxouNEuqwM1bK4w&#xA;5UEeSvKxcawnoMnJ2QlhArmrNZBoaQPxRbcul9EbLS+1MfkKxvXqwkS2ge
					yX8mX2BPyoLPdfAHb7&#xA;Otzhwqe9lToF8oWTLO0CSenI8zwPYZXkzCj6RfKKEKFOoM3fVFJv4w4i73XNCq+83C3jT/HJHGXI&#xA;g5Gz+37dl9sPv9v8HgAA//8DAFBLAwQUAAYACAAAACEAwhSrr+EAAAANAQAADwAAAGRycy9kb3du&#xA;cmV2LnhtbEyPPU/DMBCGdyT+g3VIbK2dltYlxKkQFWLo1BbB6sYmiYjPIXaT9N9zmWC7j0fvPZdt&#xA;R9ew3nah9qggmQtgFgtvaiwVvJ9eZxtgIWo0uvFoFVxtgG1+e5Pp1PgBD7Y/xpJRCIZUK6hibFPO&#xA;Q1FZp8PctxZp9+U7pyO1XclNpwcKdw1fCLHmTtdIFyrd2pfKFt/Hi1Ow3vWnnUu6Yb//lNcfgcsP&#xA;Wb4pdX83Pj8Bi3aMfzBM+qQOOTmd/QVNYI2C2eJBLImltM2KiglJ5EoCO0+jRwk8z/j/L/JfAAAA&#xA;//8DAFBLAQItABQABgAIAAAAIQC2gziS/gAAAOEBAAATAAAAAAAAAAAAAAAAAAAAAABbQ29udGVu&#xA;dF9UeXBlc10ueG1sUEsBAi0AFAAGAAgAAAAhADj9If/WAAAAlAEAAAsAAAAAAAAAAAAAAAAALwEA&#xA;AF9yZWxzLy5yZWxzUEsBAi0AFAAGAAgAAAAhAKXYU5z0AQAAtgMAAA4AAAAAAAAAAAAAAAAALgIA&#xA;AGRycy9lMm9Eb2MueG1sUEsBAi0AFAAGAAgAAAAhAMIUq6/hAAAADQEAAA8AAAAAAAAAAAAAAAAA&#xA;TgQAAGRycy9kb3ducmV2LnhtbFBLBQYAAAAABAAEAPMAAABcBQAAAAA=&#xA;" strokeweight="2.25pt">
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
					<a:latin typeface="Calibri Light" panose="020F0302020204030204"/>
					<a:ea typeface=""/>
					<a:cs typeface=""/>
				<a:font script="Hans" typeface="宋体"/>
		<a:font script="Hebr" typeface="Times New Roman"/>
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
		<a:latin typeface="Calibri" panose="020F0502020204030204"/>
		<a:ea typeface=""/>
		<a:cs typeface=""/>
	<a:font script="Hans" typeface="宋体"/>
<a:font script="Hebr" typeface="Arial"/>
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
				<w:compatSetting w:name="compatibilityMode" w:uri="http://schemas.microsoft.com/office/word" w:val="15"/>
				<w:compatSetting w:name="overrideTableStyleFontSizeAndJustification" w:uri="http://schemas.microsoft.com/office/word" w:val="1"/>
				<w:compatSetting w:name="enableOpenTypeFeatures" w:uri="http://schemas.microsoft.com/office/word" w:val="1"/>
				<w:compatSetting w:name="doNotFlipMirrorIndents" w:uri="http://schemas.microsoft.com/office/word" w:val="1"/>
				<w:compatSetting w:name="differentiateMultirowTableHeaders" w:uri="http://schemas.microsoft.com/office/word" w:val="1"/>
			</w:compat>
			<w:rsids>
				<w:rsidRoot w:val="00793991"/>
				<w:rsid w:val="00034FFF"/>
				<w:rsid w:val="00067A27"/>
				<w:rsid w:val="004E3488"/>
				<w:rsid w:val="00793991"/>
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
			<w15:chartTrackingRefBased/>
			<w15:docId w15:val="{047903FC-2FC0-4A46-B0A1-F9747F4AB216}"/>
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
			<TotalTime>0</TotalTime>
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
			<cp:revision>2</cp:revision>
			<dcterms:created xsi:type="dcterms:W3CDTF">2018-12-20T03:08:00Z</dcterms:created>
			<dcterms:modified xsi:type="dcterms:W3CDTF">2018-12-20T03:08:00Z</dcterms:modified>
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
