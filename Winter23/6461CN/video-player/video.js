let canvas
let ctx
let webcamStream
let video



const constraints = {
  video:  { 
    width: { exact: 1280 }, 
    height: { exact: 720 },
    frameRate: { ideal: 30, max: 30 }
  },
  audio: true
}

const init = function () {
  // obtain canvas context for drawing
  canvas = document.getElementById('myCanvas')
  ctx = canvas.getContext('2d')
}



// get user media and start capturing video streaming
const startWebcam = async function () {
  try {
    if (!webcamStream) {
      webcamStream = await navigator.mediaDevices.getUserMedia(constraints)
      video = document.getElementById('myVideo')
    }

    if (typeof video.srcObject !== 'undefined') {
      video.srcObject = webcamStream
    } else {
      video.src = URL.createObjectURL(webcamStream)
    }

    video.play()
  } catch (err) {
    console.error('error obtaining navigator.mediaDevices.getUserMedia')
    console.error(err.message || err)
    console.error('https://developer.mozilla.org/en-US/docs/Web/API/MediaDevices/getUserMedia#Browser_compatibility')
  }
}
let start_button = document.querySelector("#start-record");
let stop_button = document.querySelector("#stop-record");
let download_link = document.querySelector("#download-video");
let media_recorder = null;
let blobs_recorded = [];

start_button.addEventListener('click', function() {
    // set MIME type of recording as video/webm
    media_recorder = new MediaRecorder(webcamStream, { mimeType: 'video/webm;codecs="vp9"', videoBitsPerSecond:5000000 });

    // event : new recorded video blob available 
    media_recorder.addEventListener('dataavailable', function(e) {
		blobs_recorded.push(e.data);
    });

    // event : recording stopped & all blobs sent
    media_recorder.addEventListener('stop', function() {
    	// create local object URL from the recorded video blobs
    	let video_local = URL.createObjectURL(new Blob(blobs_recorded, { type: 'video/webm' }));
    	download_link.href = video_local;
        let recordedVideo = document.getElementById('recorded-video');
        recordedVideo.src = video_local;
    });

    // start recording with each recorded blob having 1 second video
    media_recorder.start(1000);
});

stop_button.addEventListener('click', function() {
	media_recorder.stop(); 
});

const stopWebcam = function () {
  if (video && video.srcObject) {
    const videoTracks = webcamStream.getVideoTracks()
    videoTracks.forEach(track => {
      track.stop()
    })

    if (typeof video.srcObject !== 'undefined') {
      video.srcObject = null
    } else {
      video.src = null
    }

    webcamStream = null
  }
}

// take a snap shot
const takeSnapshot = function () {
  // draw current image from the video onto the canvas
  if (webcamStream) {
    ctx.drawImage(video, 0, 0, canvas.width, canvas.height)
  }
}

const pauseVideo = function () {
  if (media_recorder) {
    media_recorder.pause()
  }
}

const resumeVideo = function () {
  if (media_recorder) {
    media_recorder.resume()
  }
}

// flip web cam horizontally
const toggleMirror = function () {
  const checked = document.getElementById('mirrorCheckbox').checked
  video.className = checked ? 'mirror' : ''
  canvas.className = checked ? 'mirror' : ''
}

init()
