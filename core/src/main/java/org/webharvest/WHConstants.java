/*  Copyright (c) 2006-2007, Vladimir Nikic
    All rights reserved.

    Redistribution and use of this software in source and binary forms,
    with or without modification, are permitted provided that the following
    conditions are met:

    * Redistributions of source code must retain the above
      copyright notice, this list of conditions and the
      following disclaimer.

    * Redistributions in binary form must reproduce the above
      copyright notice, this list of conditions and the
      following disclaimer in the documentation and/or other
      materials provided with the distribution.

    * The name of Web-Harvest may not be used to endorse or promote
      products derived from this software without specific prior
      written permission.

    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
    AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
    IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
    ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
    LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
    CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
    SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
    INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
    CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
    ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
    POSSIBILITY OF SUCH DAMAGE.

    You can contact Vladimir Nikic by sending e-mail to
    nikic_vladimir@yahoo.com. Please include the word "Web-Harvest" in the
    subject line.
*/
package org.webharvest;

/**
 * Created by IntelliJ IDEA.
 * User: awajda
 * Date: Sep 13, 2010
 * Time: 11:21:56 PM
 */
public class WHConstants {

    //todo: merge with org.webharvest.utils.Constants

    public static final String MIME_TYPES[] = {
            "application/x-bytecode.python",
            "application/acad",
            "application/arj",
            "application/base64",
            "application/binhex",
            "application/binhex4",
            "application/book",
            "application/cdf",
            "application/clariscad",
            "application/commonground",
            "application/drafting",
            "application/dsptype",
            "application/dxf",
            "application/envoy",
            "application/excel",
            "application/fractals",
            "application/freeloader",
            "application/futuresplash",
            "application/gnutar",
            "application/groupwise",
            "application/hlp",
            "application/hta",
            "application/i-deas",
            "application/iges",
            "application/inf",
            "application/java",
            "application/java-byte-code",
            "application/lha",
            "application/lzx",
            "application/mac-binary",
            "application/mac-binhex",
            "application/mac-binhex40",
            "application/mac-compactpro",
            "application/macbinary",
            "application/marc",
            "application/mbedlet",
            "application/mcad",
            "application/mime",
            "application/mspowerpoint",
            "application/msword",
            "application/mswrite",
            "application/netmc",
            "application/octet-stream",
            "application/oda",
            "application/pdf",
            "application/pkcs-12",
            "application/pkcs-crl",
            "application/pkcs10",
            "application/pkcs7-mime",
            "application/pkcs7-signature",
            "application/pkix-cert",
            "application/pkix-crl",
            "application/plain",
            "application/postscript",
            "application/powerpoint",
            "application/pro_eng",
            "application/ringing-tones",
            "application/rtf",
            "application/sdp",
            "application/sea",
            "application/set",
            "application/sla",
            "application/smil",
            "application/solids",
            "application/sounder",
            "application/step",
            "application/streamingmedia",
            "application/toolbook",
            "application/vda",
            "application/vnd.fdf",
            "application/vnd.hp-hpgl",
            "application/vnd.hp-pcl",
            "application/vnd.ms-excel",
            "application/vnd.ms-pki.certstore",
            "application/vnd.ms-pki.pko",
            "application/vnd.ms-pki.seccat",
            "application/vnd.ms-pki.stl",
            "application/vnd.ms-powerpoint",
            "application/vnd.ms-project",
            "application/vnd.nokia.configuration-message",
            "application/vnd.nokia.ringing-tone",
            "application/vnd.rn-realmedia",
            "application/vnd.rn-realplayer",
            "application/vnd.wap.wmlc",
            "application/vnd.wap.wmlscriptc",
            "application/vnd.xara",
            "application/vocaltec-media-desc",
            "application/vocaltec-media-file",
            "application/wordperfect",
            "application/wordperfect6.0",
            "application/wordperfect6.1",
            "application/x-123",
            "application/x-aim",
            "application/x-authorware-bin",
            "application/x-authorware-map",
            "application/x-authorware-seg",
            "application/x-bcpio",
            "application/x-binary",
            "application/x-binhex40",
            "application/x-bsh",
            "application/x-bytecode.elisp (compiled elisp)",
            "application/x-bzip",
            "application/x-bzip2",
            "application/x-cdf",
            "application/x-cdlink",
            "application/x-chat",
            "application/x-cmu-raster",
            "application/x-cocoa",
            "application/x-compactpro",
            "application/x-compress",
            "application/x-compressed",
            "application/x-conference",
            "application/x-cpio",
            "application/x-cpt",
            "application/x-csh",
            "application/x-deepv",
            "application/x-director",
            "application/x-dvi",
            "application/x-elc",
            "application/x-envoy",
            "application/x-esrehber",
            "application/x-excel",
            "application/x-frame",
            "application/x-freelance",
            "application/x-gsp",
            "application/x-gss",
            "application/x-gtar",
            "application/x-gzip",
            "application/x-hdf",
            "application/x-helpfile",
            "application/x-httpd-imap",
            "application/x-ima",
            "application/x-internett-signup",
            "application/x-inventor",
            "application/x-ip2",
            "application/x-java-class",
            "application/x-java-commerce",
            "application/x-javascript",
            "application/x-koan",
            "application/x-ksh",
            "application/x-latex",
            "application/x-lha",
            "application/x-lisp",
            "application/x-livescreen",
            "application/x-lotus",
            "application/x-lotusscreencam",
            "application/x-lzh",
            "application/x-lzx",
            "application/x-mac-binhex40",
            "application/x-macbinary",
            "application/x-magic-cap-package-1.0",
            "application/x-mathcad",
            "application/x-meme",
            "application/x-midi",
            "application/x-mif",
            "application/x-mix-transfer",
            "application/x-mplayer2",
            "application/x-msexcel",
            "application/x-mspowerpoint",
            "application/x-navi-animation",
            "application/x-navidoc",
            "application/x-navimap",
            "application/x-navistyle",
            "application/x-netcdf",
            "application/x-newton-compatible-pkg",
            "application/x-nokia-9000-communicator-add-on-software",
            "application/x-omc",
            "application/x-omcdatamaker",
            "application/x-omcregerator",
            "application/x-pagemaker",
            "application/x-pcl",
            "application/x-pixclscript",
            "application/x-pkcs10",
            "application/x-pkcs12",
            "application/x-pkcs7-certificates",
            "application/x-pkcs7-certreqresp",
            "application/x-pkcs7-mime",
            "application/x-pkcs7-signature",
            "application/x-pointplus",
            "application/x-portable-anymap",
            "application/x-project",
            "application/x-qpro",
            "application/x-rtf",
            "application/x-sdp",
            "application/x-sea",
            "application/x-seelogo",
            "application/x-sh",
            "application/x-shar",
            "application/x-shockwave-flash",
            "application/x-sit",
            "application/x-sprite",
            "application/x-stuffit",
            "application/x-sv4cpio",
            "application/x-sv4crc",
            "application/x-tar",
            "application/x-tbook",
            "application/x-tcl",
            "application/x-tex",
            "application/x-texinfo",
            "application/x-troff",
            "application/x-troff-man",
            "application/x-troff-me",
            "application/x-troff-ms",
            "application/x-troff-msvideo",
            "application/x-ustar",
            "application/x-visio",
            "application/x-vnd.audioexplosion.mzz",
            "application/x-vnd.ls-xpix",
            "application/x-vrml",
            "application/x-wais-source",
            "application/x-winhelp",
            "application/x-wintalk",
            "application/x-world",
            "application/x-wpwin",
            "application/x-wri",
            "application/x-x509-ca-cert",
            "application/x-x509-user-cert",
            "application/x-zip-compressed",
            "application/xml",
            "application/zip",
            "audio/aiff",
            "audio/basic",
            "audio/it",
            "audio/make",
            "audio/make.my.funk",
            "audio/mid",
            "audio/midi",
            "audio/mod",
            "audio/mpeg",
            "audio/mpeg3",
            "audio/nspaudio",
            "audio/s3m",
            "audio/tsp-audio",
            "audio/tsplayer",
            "audio/vnd.qcelp",
            "audio/voc",
            "audio/voxware",
            "audio/wav",
            "audio/x-adpcm",
            "audio/x-aiff",
            "audio/x-au",
            "audio/x-gsm",
            "audio/x-jam",
            "audio/x-liveaudio",
            "audio/x-mid",
            "audio/x-midi",
            "audio/x-mod",
            "audio/x-mpeg",
            "audio/x-mpeg-3",
            "audio/x-mpequrl",
            "audio/x-nspaudio",
            "audio/x-pn-realaudio",
            "audio/x-pn-realaudio-plugin",
            "audio/x-psid",
            "audio/x-realaudio",
            "audio/x-twinvq",
            "audio/x-twinvq-plugin",
            "audio/x-vnd.audioexplosion.mjuicemediafile",
            "audio/x-voc",
            "audio/x-wav",
            "audio/xm",
            "chemical/x-pdb",
            "drawing/x-dwf (old)",
            "flv-application/octet-stream",
            "i-world/i-vrml",
            "image/bmp",
            "image/cmu-raster",
            "image/fif",
            "image/florian",
            "image/g3fax",
            "image/gif",
            "image/ief",
            "image/jpeg",
            "image/jutvision",
            "image/naplps",
            "image/pict",
            "image/pjpeg",
            "image/png",
            "image/tiff",
            "image/vasa",
            "image/vnd.dwg",
            "image/vnd.fpx",
            "image/vnd.net-fpx",
            "image/vnd.rn-realflash",
            "image/vnd.rn-realpix",
            "image/vnd.wap.wbmp",
            "image/vnd.xiff",
            "image/x-cmu-raster",
            "image/x-dwg",
            "image/x-icon",
            "image/x-jg",
            "image/x-jps",
            "image/x-niff",
            "image/x-pcx",
            "image/x-pict",
            "image/x-portable-anymap",
            "image/x-portable-bitmap",
            "image/x-portable-graymap",
            "image/x-portable-greymap",
            "image/x-portable-pixmap",
            "image/x-quicktime",
            "image/x-rgb",
            "image/x-tiff",
            "image/x-windows-bmp",
            "image/x-xbitmap",
            "image/x-xbm",
            "image/x-xpixmap",
            "image/x-xwd",
            "image/x-xwindowdump",
            "image/xbm",
            "image/xpm",
            "message/rfc822",
            "model/iges",
            "model/vnd.dwf",
            "model/vrml",
            "model/x-pov",
            "multipart/x-gzip",
            "multipart/x-ustar",
            "multipart/x-zip",
            "music/crescendo",
            "music/x-karaoke",
            "paleovu/x-pv",
            "text/asp",
            "text/css",
            "text/html",
            "text/mcf",
            "text/pascal",
            "text/plain",
            "text/richtext",
            "text/scriplet",
            "text/sgml",
            "text/tab-separated-values",
            "text/uri-list",
            "text/vnd.abc",
            "text/vnd.fmi.flexstor",
            "text/vnd.rn-realtext",
            "text/vnd.wap.wml",
            "text/vnd.wap.wmlscript",
            "text/webviewhtml",
            "text/x-asm",
            "text/x-audiosoft-intra",
            "text/x-c",
            "text/x-component",
            "text/x-fortran",
            "text/x-h",
            "text/x-java-source",
            "text/x-la-asf",
            "text/x-m",
            "text/x-pascal",
            "text/x-script",
            "text/x-script.csh",
            "text/x-script.elisp",
            "text/x-script.guile",
            "text/x-script.ksh",
            "text/x-script.lisp",
            "text/x-script.perl",
            "text/x-script.perl-module",
            "text/x-script.phyton",
            "text/x-script.rexx",
            "text/x-script.scheme",
            "text/x-script.sh",
            "text/x-script.tcl",
            "text/x-script.tcsh",
            "text/x-script.zsh",
            "text/x-server-parsed-html",
            "text/x-setext",
            "text/x-sgml",
            "text/x-speech",
            "text/x-uil",
            "text/x-uuencode",
            "text/x-vcalendar",
            "text/xml",
            "video/animaflex",
            "video/avi",
            "video/avs-video",
            "video/dl",
            "video/fli",
            "video/gl",
            "video/mpeg",
            "video/msvideo",
            "video/quicktime",
            "video/vdo",
            "video/vivo",
            "video/vnd.rn-realvideo",
            "video/vnd.vivo",
            "video/vosaic",
            "video/x-amt-demorun",
            "video/x-amt-showrun",
            "video/x-atomic3d-feature",
            "video/x-dl",
            "video/x-dv",
            "video/x-fli",
            "video/x-gl",
            "video/x-isvideo",
            "video/x-motion-jpeg",
            "video/x-mpeg",
            "video/x-mpeq2a",
            "video/x-ms-asf",
            "video/x-ms-asf-plugin",
            "video/x-msvideo",
            "video/x-qtc",
            "video/x-scm",
            "video/x-sgi-movie",
            "windows/metafile",
            "www/mime",
            "x-conference/x-cooltalk",
            "x-music/x-midi",
            "x-world/x-3dmf",
            "x-world/x-svr",
            "x-world/x-vrml",
            "x-world/x-vrt",
            "xgl/drawing",
            "xgl/movie",
    };

}
